import java.io.*;
import java.lang.Thread;
import java.net.*;
import java.util.*;


public class ReverseProxy{

	public static void main(String args[]) throws IOException {

		ServerSocket ss;
		Socket socket = null;
		HashMap<InetAddress, Servidor> tabela = new HashMap<>();

		try{

			//UDP
			DatagramSocket dSocket = new DatagramSocket(5555);
			ThreadInputProxy tip = new ThreadInputProxy(tabela, dSocket);
			ThreadOutputProxy top = new ThreadOutputProxy(tabela, dSocket);
			tip.start();
			top.start();

			// TCP
			InetAddress addr = InetAddress.getByName("10.0.2.1");
			ss = new ServerSocket(80,30,addr);
			while((socket = ss.accept()) != null){
				ThreadCliente tc = new ThreadCliente(socket);
				tc.start();
			}
			tip.join();
			top.join();
			ss.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
