package tpcc;


import java.io.IOException;
import java.io.BufferedReader;


public class ThreadClientTCP{

	private BufferedReader inServer;


	public ThreadClientTCP( BufferedReader br) {
		this.inServer = br;
	}

	public ThreadClientTCP() {
		inServer = new BufferedReader();
	}

	public void run(){

		try{

			String line;
			while((line = inServer.readline())!= null) {
				System.out.println("CLIENT WRITE THIS: " + line);
			}
		}
		catch( IOException e) {
			System.out.println(e.getMessage());
		}
	}
}