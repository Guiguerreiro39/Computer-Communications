package tpcc;


import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;


public class ClientTCP extends Thread {


	public static void main(String [] args) throws IOException {

		try {

			Socket soc = new Socket("localhost",80);
			BufferedReader cliInput =  new BufferedReader(new InputStreamReader(System.in));
			BufferedReader serInput =  new BufferedReader(new InputStreamReader(soc.getInputStream())); 
			String cmd;
			PrintWriter output = new PrintWriter(soc.getOutputStream()));

			
			Thread smsCli = new Thread(new ThreadClientTCP());
			smsCli.start();

			while( !(comando = cliInput.readLine()).equals("Logout")) {

				output.println(cmd);
				output.flush();
			}

			soc.shutdownInput();
			soc.shutdownOutput();
			soc.close();
		}
		catch(IOException e) {
			System.out.prinln(e.getMessage());
		}
	
	}
	
}