package com.socket.examples;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.apache.log4j.Logger; 

public class Example5UsingDatagramSocket {
	public static Logger log = Logger.getLogger(Example5UsingDatagramSocket.class);

	public static void main(String[] args) throws IOException {

		Example5UsingDatagramSocket ex = new Example5UsingDatagramSocket();
		ex.createSocketObject();
//		ex.receiveFromDatagram();
	}

	private void receiveFromDatagram() throws IOException {
		DatagramSocket ds=new DatagramSocket(3000);
	    byte[] buf = new byte[12];  
	    
		DatagramPacket dp=new DatagramPacket(buf,buf.length );
		ds.receive(dp);
		String msg=new String(dp.getData(),0,dp.getLength());
		log.debug("message recevied from server -> "+msg);
		ds.close();
	}

	private void createSocketObject() throws IOException {
		DatagramSocket ds=new DatagramSocket();
		String msg="Welcome java";
		InetAddress inet=InetAddress.getByName("127.0.0.1");
		
		DatagramPacket dp=new DatagramPacket(msg.getBytes(),msg.length(),inet, 3000);
		ds.send(dp);
		ds.close();
		
	}
}
