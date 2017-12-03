package simple.chat.program;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.bizruntime.socket.ClientExample;

public class Client {
	public static Logger log = Logger.getLogger(ClientExample.class);

	public static void main(String[] args) {
		Client ex = new Client();
		ex.createSocketObject();
	}

	private void createSocketObject() {
		String host = "localhost";
		int port = 9099;
		Socket client = null;
		InetAddress inet = null;
		try {
			client = new Socket(host, port);

			DataOutputStream out = new DataOutputStream(
					client.getOutputStream());
			out.writeUTF("Hello from client");
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			System.out.println("Server says " + in.readUTF());
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
