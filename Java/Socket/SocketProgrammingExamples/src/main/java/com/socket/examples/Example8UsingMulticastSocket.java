package com.socket.examples;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Example8UsingMulticastSocket {
	public static void main(String[] args) throws IOException {
		Example8UsingMulticastSocket ex=new Example8UsingMulticastSocket();
		ex.createSocketObject();
		
	}
	
	 private void createSocketObject() throws IOException {
	int port = 9099;
	    byte ttl = (byte) 1;

	    InetAddress ia = InetAddress.getByName("224.168.1.17");

	    
   	    byte[] data = "Here's some multicast data\r\n".getBytes();
	    DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);

	    MulticastSocket ms = new MulticastSocket();
	    ms.joinGroup(ia);
	    for (int i = 1; i < 10; i++) {
	   //   ms. send(dp, ttl);
	      ms.send(dp);
	    }
	    ms.leaveGroup(ia);
	    ms.close();
}
}
