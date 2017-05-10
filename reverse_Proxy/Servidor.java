package CC;

public class Servidor{

	private long rtt;
	private float taxa;
	private int tcpNum;

	synchronized public Servidor(long rtt, float taxa, int tcpNum){
		this.rtt = rtt;
		this.taxa = taxa;
		this.tcpNum = tcpNum;
	}

	synchronized public getRtt(){
		return rtt;
	}

	synchronized public getTaxa(){
		return taxa;
	}

	synchronized public getTcpNum(){
		return tcpNum;
	}

	synchronized public setRtt(long rtt){
		this.rtt = rtt;
	}

	synchronized public void setTcpNum(int tcpNum){
		this.tcpNum = tcpNum;
	}
}