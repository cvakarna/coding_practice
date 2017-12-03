package com.bizruntime.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketPermission;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

public class ClientExample {
	public static Logger log = Logger.getLogger(ClientExample.class);

	public static void main(String[] args) throws InterruptedException {
		ClientExample ex = new ClientExample();
		ex.createSocketObject();
	}

	private void createSocketObject() throws InterruptedException {

		String host = "localhost";
		int port = 9099;
		Socket client = null;
		try {
			client = new Socket(host, port);
			log.debug("InetAddress for server " + client.getInetAddress());
			log.debug("port number " + client.getPort());
			log.debug("port the socket is bound to on the local machine. "
					+ client.getLocalPort());
			log.debug("Address of remote socket"
					+ client.getRemoteSocketAddress());
		} catch (UnknownHostException e) {
			log.error(" Invalid host name " + e.getMessage());
		} catch (IOException e) {
			log.error(port + " port number not in use : " + e.getMessage());
		} finally {

			try {

				client.close();
			} catch (IOException e) {
				log.error(" Exception onclosing connection : " + e.getMessage());
			}
		}
	}
}
