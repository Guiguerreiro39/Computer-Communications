package CC;

import java.io.*;
import java.net.*;
import java.util.*;
import CC.*;

public class ThreadOutputProxy extends Thread{

	private HashMap<InetAddress, Servidor> tabela;
	private DatagramSocket dSocket;

	public ThreadOutputProxy(HashMap<InetAddress, Servidor> tabela, DatagramSocket dSocket) {
			this.tabela = tabela;
			this.dSocket = dSocket;
	}

	public void run() {
		int i;
		byte[] buffer = new byte[500];
		DatagramPacket dPacket = new DatagramPacket(buffer, 500);

		try{
			while(true){
				for(i=0;i < tabela.size();i++) { 
				MonitorByte omb = new MonitorByte(buffer);
			    InetAddress IPAddress = omb.getAddress();
			    int port = omb.getPort();
				byte[] btt = omb.converteByte();
				DatagramPacket sendPacket = new DatagramPacket(btt, btt.length, IPAddress, port);
				dSocket.send(sendPacket);
				}
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}