

import java.io.*;
import java.net.*;


public class ThreadCliente extends Thread{

	private Socket socket;


	public ThreadCliente( Socket socket) {
		this.socket = socket;
	}

	public void run(){
	}
}
