package UDP;

import java.io.IOException;
import java.net.Socket;
import java.net.DatagramSocket;
import java.net.DatagramPac

public class ThreadUDP{

	DatagramSocket dSocket;

	public ThreadUDP(DatagramSocket dSocket){
		this.dSocket = dSocket;
	}

	public void run(){
		byte[] buffer = new byte[500];
		byte[] receiveData = new byte[500];
        byte[] sendData;

		while(true){
	        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	        dSocket.receive(receivePacket);

	        MonitorByte mb = new MonitorByte(receivePacket.getData());

	        InetAddress IPAddress = mb.getAddress();
	        int port = mb.getPort();
	         
	        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
	        serverSocket.send(sendPacket);
		}
	}
}