package tpcc;

import java.io.IOException;
import java.net.Socket;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class ThreadOutputProxy(){

	private HashMap<InetAddress, Servidor> tabela;
	private DatagramSocket dSocket;

	public ThreadOutputServidor(HashMap<InetAddress, Servidor> tabela, DatagramSocket dSocket) {
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
				MonitorByte omb = new MonitorByte();
				byte[] btt = omb.converteByte();
				dSocket.send(btt);
				}
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}