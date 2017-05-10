package tpcc;

import java.io.IOException;
import java.net.Socket;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class ThreadOutputProxyUDP(){

	private HashMap<InetAddress, Servidor> tabela;
	private DatagramSocket dSocket;

	public ThreadOutputProxyUDP(HashMap<InetAddress, Servidor> tabela, DatagramSocket dSocket) {
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
				MonitorByte mb = new MonitorByte(dPacket.getData());
				byte[] btt = mb.converteByte();
				dSocket.send(btt);
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}