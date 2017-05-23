package tpcc;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP extends Thread {


	public static void main(String args[]) throws Exception{

		ServerSocket socket = new ServerSocket(80);
		ThreadServerTCP serverTCP;
		System.out.println("SERVER TCP CRIADO");
		


		while(1) {

			try{
				Socket ss = socket.accept();
				serverTCP = new ThreadServerTCP(socket);
				serverTCP.start();
			}
			catch(Exception e) {
				e.getMessage();
			}
		}
	}
}
