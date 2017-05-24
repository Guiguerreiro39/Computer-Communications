import java.lang.Thread;
import java.util.Random;
import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.HashMap;

public class ThreadCheck extends Thread {
	private HashMap<InetAddress, Servidor> tabela;


	public ThreadCheck (HashMap<InetAddress, Servidor> tabela){
		this.tabela = tabela;
	}

	private void print(){
		for(Servidor s: tabela.values()){

			if(s==null) System.out.println("Cenas");
	
			System.out.println("Endereço: " + s.getEndIP() +
						 	"\nPorta: " + s.getPort() +
						 	"\nRTT: "+ s.getRtt() + 
					     	"\nTaxa: " + s.getTaxa() +
						 	"\nNumCont: " + s.getNumConnect() + 
						 	"\nAvailable: "+ s.getNumPacket());
			}
	}

	public void run(){
		try{	
			System.out.println("RPCheckAvailable start");
			while(true){
				long time = System.currentTimeMillis();
				for(Servidor s: tabela.values()){
					
					boolean status = s.getCheck();
					long timeServer = s.getLast();

					if( status && ((time - timeServer))>=15*1000 ){
						s.setCheck(false);
					}
				}
				print();
				Thread.sleep(60000);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}	
}