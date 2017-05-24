
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.Thread;

public class ThreadOutputProxy extends Thread{

	private DatagramSocket dSocket;
	private HashMap<InetAddress, Servidor> tabela;

	public ThreadOutputProxy(HashMap<InetAddress, Servidor> tabela, DatagramSocket dSocket) {
			this.dSocket = dSocket;
			this.tabela = tabela;
	}

	public void run() {
		byte[] buffer = new byte[500];
		DatagramPacket dPacket = new DatagramPacket(buffer, 500);

		try{
			while(true){

				for(Servidor s : tabela.values()){

					InetAddress endIP = s.getEndIP();
					int port = s.getPort();

					MonitorByte omb = new MonitorByte(endIP, s.getNumPacket(),  port);
					byte[] btt = omb.converteByte();

					DatagramPacket sendPacket = new DatagramPacket(btt, btt.length, endIP, port);
					dSocket.send(sendPacket);
				}
				Thread.sleep(3000);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
