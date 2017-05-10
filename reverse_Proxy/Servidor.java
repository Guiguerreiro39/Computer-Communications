public class Servidor{

	private long rtt;
	private float taxa;
	private int tcpNum;

	public Servidor(long rtt, float taxa, int tcpNum){
		this.rtt = rtt;
		this.taxa = taxa;
		this.tcpNum = tcpNum;
	}

	public getRtt(){
		return rtt;
	}

	public getTaxa(){
		return taxa;
	}

	public getTcpNum(){
		return tcpNum;
	}

	public setRtt(long rtt){
		this.rtt = rtt;
	}

	public void setTcpNum(int tcpNum){
		this.tcpNum = tcpNum;
	}
}