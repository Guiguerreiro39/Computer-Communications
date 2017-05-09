package tpcc;

import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class ServerUDP {


	public static void main(String args[]) throws Exception{

		DatagramSocket socket = new DatagramSocket(5555);
		byte[] receivedData = new byte[1024];
		byte[] sendedData = new byte[1024];

		while(1) {

			DatagramPacket receivedP = new DatagramPacket(receivedData,receivedData.length());
			socket.receive(receivedP);

			String dados = new String(receivedP.getData());
			System.out.println("RECEIVED DATA: " + dados);

			InetAddress IPAddress = receivedP.getAdress();
			int port = receivedP.getPort();
			System.out.println("PORT: " + port);

			String sentenceP = sentence.toUperCase();
			sendedData = sentenceP.getBytes();

			DatagramPacket sendedPack = new DatagramPacket(sendedData,sendedData.length(),IPAddress,port);

			socket.send(sendedPack);
		}


	}
}