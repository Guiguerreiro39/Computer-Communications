package tpcc;


import java.io.IOException;
import java.net.Socket;


public class ThreadClientTCP{

	private Socket socket;


	public ThreadClientTCP( Socket socket) {
		this.socket = socket;
	}

	public void run(){

		try{
			
		}
		catch( IOException e) {
			System.out.println(e.getMessage());
		}
	}
}