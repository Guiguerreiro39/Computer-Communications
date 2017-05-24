
import java.io.*;
import java.net.*;

public class Servidor implements Serializable{

	private InetAddress endIP;
    private int port;
	private long rtt;
	private float taxa;
	private int numConnect;
	private int numPacket;
	private long last;
	private boolean check;

	public Servidor(InetAddress endIP, int port, long rtt, float taxa, int numConnect, int numPacket, long last, boolean check){
		this.endIP = endIP;
		this.port = port;
		this.rtt = rtt;
		this.taxa = taxa;
		this.numConnect = numConnect;
		this.numPacket = numPacket;
		this.last = last;
		this.check = check;
	}

	synchronized public InetAddress getEndIP(){
		return endIP;
	}

	synchronized public int getPort(){
		return port;
	}

	synchronized public long getRtt(){
		return rtt;
	}

	synchronized public float getTaxa(){
		return taxa;
	}

	synchronized public int getNumConnect(){
		return numConnect;
	}

	synchronized public int getNumPacket(){
		return numPacket;
	}

	synchronized public long getLast(){
		return last;
	}

	synchronized public boolean getCheck(){
		return check;
	}

	synchronized public void setRtt(long rtt){
		this.rtt = rtt;
	}

	synchronized public void setNumConnect(int numConnect){
		this.numConnect = numConnect;
	}

	synchronized public void setNumPacket(int numPacket){
		this.numPacket = numPacket;
	}

	synchronized public void setLast(long last){
		this.last = last;
	}

	synchronized public void setCheck(boolean check){
		this.check = check;
	}
}
