
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.Thread;

public class ThreadInputProxy extends Thread{

	private HashMap<InetAddress, Servidor> tabela;
	private DatagramSocket dSocket;

	public ThreadInputProxy(HashMap<InetAddress, Servidor> tabela, DatagramSocket dSocket) {
			this.tabela = tabela;
			this.dSocket = dSocket;
	}

	public void updateTabela(MonitorByte mb){
		Servidor s = tabela.get(mb.getAddress());
		long millis = System.currentTimeMillis();

		if(mb.getNumPacket() != -1){
			long rtt = (long) ((1-0.125)*s.getRtt()) + (long) (0.125*(millis-mb.getTempSaida()));
			s.setRtt(rtt);
			tabela.put(mb.getAddress(), s);
		}
		else{
			s.setCheck(true);
			s.setLast(millis);
		}
	}

	public void run(){
		byte[] buffer = new byte[500];
		DatagramPacket dPacket = new DatagramPacket(buffer, buffer.length);
		try{
			while(true){
				this.dSocket.receive(dPacket);
				MonitorByte mb = new MonitorByte(dPacket.getData());

				if(!tabela.containsKey(mb.getAddress())){
					Servidor sv = new Servidor(dPacket.getAddress(), dPacket.getPort(), 0, 0, 0, 1, System.currentTimeMillis(), true);
					tabela.put(mb.getAddress(), sv);
				}
				else{
					updateTabela(mb);
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
