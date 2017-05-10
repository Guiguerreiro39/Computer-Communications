package CC;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.DatagramSocket;
import java.util.concurrent.locks.Condition;


public class ServerProxy {

	public static void main(String args[]) throws IOException {
		Tabela tabela;
		Socket socket;
		try{
			DatagramSocket dSocket = new DatagramSocket(5555);
			ThreadInputProxy tip = new ThreadInputProxy(tabela, dSocket);
			ThreadOutputProxy top = new ThreadOutputProxy(tabela, dSocket);
			tip.start();
			top.start();
			ServerSocket ss = new ServerSocket(80);
			while((socket == ss.accept()) != null){
				ThreadCliente tc = new ThreadCliente(socket);
				tc.start();
			}
			tip.join();
			top.join();
			ss.close();
		}
		catch( IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}