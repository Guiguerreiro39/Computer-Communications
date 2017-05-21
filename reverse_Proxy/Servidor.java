package CC;

public class Servidor{

	private long rtt;
	private float taxa;
	private int tcpNum;

	public Servidor(long rtt, float taxa, int tcpNum){
		this.rtt = rtt;
		this.taxa = taxa;
		this.tcpNum = tcpNum;
	}

	synchronized public long getRtt(){
		return rtt;
	}

	synchronized public float getTaxa(){
		return taxa;
	}

	synchronized public int getTcpNum(){
		return tcpNum;
	}

	synchronized public void setRtt(long rtt){
		this.rtt = rtt;
	}

	synchronized public void setTcpNum(int tcpNum){
		this.tcpNum = tcpNum;
	}
}