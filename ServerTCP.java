import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP extends Thread {


	public static void main(String args[]) throws Exception{

		ServerSocket socket = new ServerSocket(80);
		System.out.println("SERVER TCP CRIADO");
		// thread servidorTCP ;


		while(1) {

			try{
				Socket ss = socket.accept();
				serverThTCP = // new thread servidor
				// iniciar a thread 
			}
			catch(Exception e) {
				e.getMessage();
			}
		}
	}
}
