//package UDP;

import java.io.*;
import java.net.*;

public class ThreadMonitor extends Thread {

	private DatagramSocket dSocket;

	public ThreadMonitor(DatagramSocket dSocket){
		this.dSocket = dSocket;
	}

	public void run(){
		byte[] buffer = new byte[500];
		DatagramPacket dPacket = new DatagramPacket(buffer, buffer.length);
		try{
			while(true){
				dSocket.receive(dPacket);
				MonitorByte mp = new MonitorByte(dPacket.getData());
				MonitorByte mp2 = new MonitorByte(dPacket.getAddress(), mp.getNumPacket(), dPacket.getPort());
				mp2.setTempSaida(mp.getTempSaida());
				byte[] buf = mp2.converteByte();
				
				DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, dPacket.getAddress(), dPacket.getPort());
				dSocket.send(sendPacket);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}	
	}
}
