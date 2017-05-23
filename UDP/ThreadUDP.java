package CC;

import java.io.*;
import java.net.*;

public class ThreadUDP extends Thread{

	DatagramSocket dSocket;
	boolean status;

	public ThreadUDP(boolean svStatus, DatagramSocket dSocket){
		this.dSocket = dSocket;
		this.status = status;
	}

	public void run(){
		byte[] buffer = new byte[500];
		DatagramPacket dPacket = new DatagramPacket(buffer, buffer.length);
		try{
			InetAddress addr = InetAddress.getByName("10.0.2.10");

			while(true){
				if(status){
					System.out.println("Available");
			        MonitorByte mb = new MonitorByte(dPacket.getAddress(), -1, dPacket.getPort());
			        byte[] buf = mb.converteByte();
			         
			        DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, addr, 5555);
			        dSocket.send(sendPacket);
			        Thread.sleep(3000);
		    	}
		    	else{
		    		Thread.sleep(3000);
		    		System.out.println("Dead");
		    	}
			}

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}