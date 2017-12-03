package com.socket.examples;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

public class Example1UsingSocket {
	public static Logger log = Logger.getLogger(Example1UsingSocket.class);

	public static void main(String[] args) throws IOException {
		Example1UsingSocket ex = new Example1UsingSocket();
		ex.createSocketObject();
	}

	private void createSocketObject() throws IOException {
		String host = "192.168.1.17";
		int port = 9090;
		Socket client = null;
		try {
		//	client = new Socket(host, port);
			client=new Socket();
			
			
			//client.connect(new InetSocketAddress("192.168.1.17",9099));
			client.connect(new InetSocketAddress("www.google.com",80));
			
			log.debug("InetAddress for server -> " + client.getInetAddress());
			log.debug("port number -> " + client.getPort());
			log.debug("Local Address -> " + client.getLocalAddress());
			
			log.debug("port the socket is bound to on the local machine. -> "
					+ client.getLocalPort());
			
			
			log.debug("Address of remote socket -> "
					+ client.getRemoteSocketAddress());
			
			log.debug("isBound -> "+client.isBound());
			
			log.debug("Inet Address -> "+client.getInetAddress());
			
			log.debug("Local  Socket Address -> "+client.getLocalSocketAddress());
			
			log.debug("channel  "+client.getChannel());
			InputStream ip=client.getInputStream();
			OutputStream output=client.getOutputStream();
			output.write(1);
			client.sendUrgentData(1);
			
			log.debug("socket is connected  -> "+client.isConnected());
		}finally {

			try {

				client.close();
				log.debug("Socket is closed -> "+client.isClosed());
			} catch (IOException e) {
				log.error(" Exception onclosing connection : " + e.getMessage());
			}
		}
	}
}
