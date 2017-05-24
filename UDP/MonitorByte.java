//package UDP;
import java.io.*;
import java.net.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import UDP.*;

public class MonitorByte implements Serializable{

	private long tempSaida;
	private InetAddress address;
	private int numPacket;
	private int port;

    public MonitorByte(InetAddress address, int numPacket, int port){
        this.tempSaida = System.currentTimeMillis();
        this.address = address;
        this.numPacket = numPacket;
        this.port = port;
    }

	public MonitorByte(byte[] data){
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInput in = null;
        Object o = null;
        try {
            in = new ObjectInputStream(bis);
            o = in.readObject(); 

            MonitorByte pm = (MonitorByte) o;

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

    void setTempSaida(long tempSaida){
        this.tempSaida = tempSaida;
    }
    
    public void setNumPacket(int numPacket){
        this.numPacket = numPacket;
    }

    public void setPort( int port){
        this.port = port;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

}
