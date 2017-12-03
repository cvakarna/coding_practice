package com.socket.examples;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketPermission;

import org.apache.log4j.Logger;

public class Example4UsingSocketPermission {
	public static Logger log = Logger
			.getLogger(Example4UsingSocketPermission.class);

	public static void main(String[] args) throws IOException {
		Example4UsingSocketPermission ex = new Example4UsingSocketPermission();
		ex.createSocketObject();
	}

	private void createSocketObject() throws IOException {
	
		SocketPermission socketPer=new SocketPermission("localhost:9099", "connect, accept");
		
		
	}
}
