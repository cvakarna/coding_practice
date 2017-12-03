package com.socket.examples;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;

import org.apache.log4j.Logger;

public class Example9UsingProxy {
	public static Logger log = Logger.getLogger(Example9UsingProxy.class);

	public static void main(String[] args) throws IOException {

		Example9UsingProxy ex = new Example9UsingProxy();
		ex.createSocketObject();
	}

	private void createSocketObject() throws IOException {	
		Socket socket=new Socket(Proxy.NO_PROXY);
		Socket s = new Socket(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("localhost", 9099)));
		s.connect(new InetSocketAddress(9099));
		log.debug("Connected");
	}
}
