import java.io.*;
import java.net.*;

class UDPServidor{

   public static void main(String args[]) throws Exception{

      DatagramSocket dSocket = new DatagramSocket(5555);

      byte[] receiveData = new byte[500];
      byte[] sendData;

      while(true)
      {
         DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
         dSocket.receive(receivePacket);

         MonitorByte mb = new MonitorByte(receivePacket.getData());

         InetAddress IPAddress = mb.getAddress();
         int port = mb.getPort();
         
         DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
         serverSocket.send(sendPacket);
      }
   }
}