import java.io.*;
import java.net.*;

public class Server {

	public static void main (String args[]) {

		try{
			ServidorEstado server = new ServidorEstado();
			Socket soc;

			MonitorByte mon = new MonitorByte(servidor, 5);

			mon.start();


			m.join();
		}
		catch(Exception e){
			System.out.println("Erro no servidor");
		}
	}
}