package tpcc;

import java.io.IOException;
import java.net.Socket;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class ThreadInputServidor(){

	private HashMap<InetAddress, Servidor> tabela;
	private DatagramSocket dSocket;

	public ThreadInputServidor(HashMap<InetAddress, Servidor> tabela, DatagramSocket dSocket) {
		this.tabela = tabela;
		this.dSocket = dSocket;
	}

	public void updateTabela(MonitorByte mb){
		if(mb.getNumPacket != -1){
			tabela.put(mb.getAddress(), )
		}
	}

	public void run(){
		byte[] buffer = new byte[500];
		DatagramPacket dPacket = new DatagramPacket(buffer, 500);
		try{
			while(true){
				this.dSocket.receive(dPacket);
				MonitorByte mb = new MonitorByte(dPacket.getData());

				if(!tabela.contains(mb.getAddress())){
					// update tabela -> add tabela
				}
				else{
					updateTabela(mb); //actualizar dados
				}
			}
		}
		catch( IOException e) {
			System.out.println(e.getMessage());
		}
	}
}