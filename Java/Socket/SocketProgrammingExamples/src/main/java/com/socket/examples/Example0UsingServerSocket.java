package com.socket.examples;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

import org.apache.log4j.Logger;


public class Example0UsingServerSocket {
	public static Logger log = Logger.getLogger(Example0UsingServerSocket.class);

	public static void main(String[] args) throws IOException {
		Example0UsingServerSocket ex = new Example0UsingServerSocket();
		ex.createSocketObject();
	}

	private void createSocketObject() throws IOException {
		ServerSocket server=new ServerSocket();
		
		log.debug("setting resuce use address ");
		server.setReuseAddress(true);
		
		//SocketAddress to bind the address to Server def constructor
		InetSocketAddress skadd=new InetSocketAddress("192.168.1.17",9099);
		log.debug("Bounded or not -> "+server.isBound());
		
		server.bind(skadd);
		server.setSoTimeout(3000);

		log.debug("Port number which socket is listening -> "+server.getLocalPort());
		log.debug("Inet Address (IP address) -> "+server.getInetAddress());
		log.debug("SocketAddress -> "+server.getLocalSocketAddress());
		log.debug("Buffer size -> "+server.getReceiveBufferSize());
		log.debug("ReuseAddress -> "+server.getReuseAddress());
		log.debug("socket timeout ->"+server.getSoTimeout());
		log.debug("Bounded or not -> "+server.isBound());
		
		log.debug("Setting buffer size ");
		server.setReceiveBufferSize(75537);
		log.debug("Buffer size after modified-> "+server.getReceiveBufferSize());
	    log.debug("settting performance... ");
		server.setPerformancePreferences(1000,2000,2000);

		Socket socket=server.accept();
		
		server.close();
	}
}
