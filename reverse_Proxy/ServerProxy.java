package CC;
import java.io.*;
import java.net.*;
import java.util.*;
import CC.*;


public class ServerProxy{

	public static void main(String args[]) throws IOException {
		HashMap<InetAddress, Servidor> tabela = new HashMap<>();
		Socket socket;
		try{
			DatagramSocket dSocket = new DatagramSocket(5555);
			ThreadInputProxy tip = new ThreadInputProxy(tabela, dSocket);
			ThreadOutputProxy top = new ThreadOutputProxy(tabela, dSocket);
			tip.start();
			top.start();
			ServerSocket ss = new ServerSocket(80);
			while((socket = ss.accept()) != null){
				ThreadCliente tc = new ThreadCliente(socket);
				tc.start();
			}
			ss.close();
		}
		catch( IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}