package com.bizruntime.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketPermission;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

public class ServerExample {
	public static Logger log = Logger.getLogger(ServerExample.class);

	public static void main(String[] args) throws UnknownHostException {
		ServerExample ex = new ServerExample();
		ex.createSocketObject();
		log.info(InetAddress.getLocalHost().getCanonicalHostName());

	}

	private void createSocketObject() {
		int port = 9099;
		int clientsInQueue = 10;
		int timeout=30000;
		ServerSocket server=null;
		
		try {
			// server = new ServerSocket(9099);
			   server=new ServerSocket(port,clientsInQueue);
		}catch (IOException e) {
			log.error(port + " port is already in use : " + e.getMessage());
		}

		log.debug(server.getLocalPort());
		try {
			server.setSoTimeout(timeout);
			server.accept();

		} catch (IOException e) {
			log.error("No client are connected in given time : " + e.getMessage());
		}catch (Exception e) {
			log.error(e.getMessage());
		}

		
	}
}
