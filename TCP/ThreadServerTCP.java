package tpcc;

import java.net.Socket;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;


public class ThreadServerTCP extends Thread {

	private Socket socket;

	public ThreadServerTCP() {
		socket = new Socket(80);
	}

	public ThreadServerTCP( Socket s) {
		this.socket = s;
	}


	public void run() {

		System.out.println("Servidor á espera...");

		try {

			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			BufferedReader bf = new BufferedReader( new InputStreamReader (socket.getInputStream()));
			String line = bf.readline();

			while( line != null) {

				System.out.println("SERVER TCP WAITING ...");
				System.out.println("CLIENT :  "  + line);

				pw.flush();

				line = bf.readline();
			}

			System.out.println("CONECTION DONE");
			socket.close();
		}
		catch(IOException e) {
			System.out.prinln(e.getMessage());
		}

	}

}