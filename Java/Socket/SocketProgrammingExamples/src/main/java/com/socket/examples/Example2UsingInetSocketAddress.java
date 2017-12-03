package com.socket.examples;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

public class Example2UsingInetSocketAddress {
	public static Logger log = Logger.getLogger(Example2UsingInetSocketAddress.class);

	public static void main(String[] args) throws IOException {
		Example2UsingInetSocketAddress ex = new Example2UsingInetSocketAddress();
		ex.createSocketObject();
	}

	private void createSocketObject() throws IOException {
		
		ServerSocket server=new ServerSocket();
		
		InetSocketAddress sckad1=new InetSocketAddress("192.168.1.17",5000);
		log.debug("is Unresolved "+sckad1.isUnresolved());
		
		InetSocketAddress sckad2=InetSocketAddress.createUnresolved("localhost", 5000);
		log.debug("is Unresolved "+sckad2.isUnresolved());
//		Socket client=new Socket();
		
		InetAddress add=sckad2.getAddress();
		log.debug("InetAddress -> "+add);
		
		InetSocketAddress sckad3=new InetSocketAddress("host",5000);
		log.debug(""+sckad3.getHostName());
		
		//server.bind(sckad3);    //unresolved error
		//server.bind(sckad2);    //unresolved error
		server.bind(sckad1);     //no error
		
		Socket sk=new Socket();
		
	//	sk.connect(sckad2); //unresolved error
		
	}
}
