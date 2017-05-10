package UDP;

import java.io.*;
import java.net.*;

public class MonitorUDP{

	public static main(String args[]){

		DatagramSocket dSocket = new DatagramSocket(5555);
		byte[] sendData;

		ThreadUDP tUDP = new ThreadUDP(dSocket);

		tUDP.start();

		while(true){
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, "Estou disponível");
			sleep(3000);
			serverSocket.send(sendPacket);			
		}
	}
}
