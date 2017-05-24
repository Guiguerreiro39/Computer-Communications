
import java.io.*;
import java.net.*;

public class MonitorUDP{

	public static void main(String args[]){
		try{
			System.out.println("Monitor UDP up!");
			boolean status = true;
			DatagramSocket dSocket = new DatagramSocket(5555);

			ThreadUDP tUDP = new ThreadUDP(status, dSocket);
			ThreadMonitor tm = new ThreadMonitor(dSocket);
			tUDP.start();
			tm.start();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}	
	}
}
