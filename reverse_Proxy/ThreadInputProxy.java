package CC;

import java.io.IOException;
import java.net.Socket;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class ThreadInputProxyUDP(){

	private HashMap<InetAddress, Servidor> tabela;
	private DatagramSocket dSocket;

	public ThreadInputProxyUDP(HashMap<InetAddress, Servidor> tabela, DatagramSocket dSocket) {
		this.tabela = tabela;
		this.dSocket = dSocket;
	}

	public void updateTabela(MonitorByte mb){
		if(mb.getNumPacket != -1){
			long millis = System.currentTimeMillis();
			Servidor s = tabela.get(mb.getAddress());
			rtt = (1-0.125)*s.getRtt()+0.125*(millis-mb.getTempSaida());
			s.setRtt(rtt);
			s.setTcpNum(s.getTcpNum()+1);
			tabela.put(mb.getAddress(), s);
		}
	}

	public void run(){
		byte[] buffer = new byte[500];
		DatagramPacket dPacket = new DatagramPacket(buffer, buffer.length);
		try{
			while(true){
				this.dSocket.receive(dPacket);
				MonitorByte mb = new MonitorByte(dPacket.getData());

				if(!tabela.contains(mb.getAddress())){
					float taxa = mb.getNumPacket()*100;
					Servidor sv = new Servidor(1, taxa, 1);
					tabela.put(mb.getAddress(), sv);
				}
				else{
					updateTabela(mb);
				}
			}
		}
		catch( IOException e) {
			System.out.println(e.getMessage());
		}
	}
}