public class MonitorByte{

	private long tempSaida;
	private InetAddress address;
	private int numPacket;
	private int port;

	public PacoteMonitor(byte[] data){
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInput in = null;
        Object o = null;
        try {
            in = new ObjectInputStream(bis);
            o = in.readObject(); 

            PacoteMonitor pm = (PacoteMonitor) o;

            this.numPacket = pm.getNumPacket();
            this.tempSaida = pm.getTempSaida();
            this.address = pm.getAddress();
            this.port = pm.getPort();
        }
        catch(Exception ex){
            System.out.println("BytesErro");
        }
    }

    public byte[] converteByte(){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        byte[] data = null;
        try {
            out = new ObjectOutputStream(bos);   
            out.writeObject(this);
            out.flush();
            data = bos.toByteArray();
        } 
        catch (Exception ex) {
            System.out.println("converteByteErro");
        }
        return data;
    }

    public int getNumPacket(){
    	return numPacket;
    }

    public int getPort(){
    	return port;
    }

    public long getTempSaida(){
    	return tempSaida;
    }

    public InetAddress getAddress(){
    	return address;
    }
    
}