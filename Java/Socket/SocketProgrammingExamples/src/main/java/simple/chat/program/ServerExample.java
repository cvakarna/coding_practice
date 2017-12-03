package simple.chat.program;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

public class ServerExample {
	public static Logger log = Logger.getLogger(ServerExample.class);

	public static void main(String[] args) {
		ServerExample ex = new ServerExample();
		ex.createSocketObject();
	}

	private void createSocketObject() {
		int port = 9099;
		int clientsInQueue = 10;
		int timeout = 10000;
		ServerSocket server = null;
		Socket clientSocket = null;
		try {
			server = new ServerSocket(port);
			server.setSoTimeout(timeout);
			clientSocket = server.accept();
			
			DataInputStream in = new DataInputStream(
					clientSocket.getInputStream());
			System.out.println(in.readUTF());

			DataOutputStream out = new DataOutputStream(
					clientSocket.getOutputStream());
			out.writeUTF("Thank you for connecting ");
			
			
			
			
		} catch (IOException e) {
			log.error("IOException Occurred " + e.getMessage());
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				log.error("exception Occurred on closing an connection" + e.getMessage());
			}
		}

	}
}
