import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ServerEstado {

	private boolean livre;

	public ServerEstado() {
		this.livre = true;
	}

	public synchronized boolean getEstado() {
		return this.livre;
	}

	public synchronized void setEstado(boolean livre) {
		this.livre = livre;
	}


} 