package com.bizruntime.socket;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.JFrame;

//Unicast messaging is used for all network processes in which a private or unique resource is requested. 

public class Unicast extends JFrame implements ActionListener {
	Label entermsgl, receivedmsgl, sentmsgl, toportl;
	TextField entermsg, toport;
	TextArea receivedmsg, sentmsg;
	Button send, exit;
	int myport;
	DatagramSocket ds;
	DatagramPacket dp;

	Unicast() {
		new InputDialog(this);
	}

	public void initialise() {
		setTitle("Unicast --Port:" + myport);
		setVisible(true);
		setSize(600, 400);
		entermsgl = new Label("Enter Message:");
		receivedmsgl = new Label("Received Messages:");
		sentmsgl = new Label("Sent Messages:");
		toportl = new Label("To");
		toport = new TextField();
		entermsg = new TextField();
		receivedmsg = new TextArea();
		sentmsg = new TextArea();
		send = new Button("Send");
		exit = new Button("Exit");
		setLayout(null);
		add(entermsgl);
		entermsgl.setBounds(25, 25, 100, 25);
		add(receivedmsgl);
		receivedmsgl.setBounds(25, 70, 150, 25);
		add(sentmsgl);
		sentmsgl.setBounds(25, 185, 150, 25);
		add(toportl);
		toportl.setBounds(350, 25, 25, 25);
		add(toport);
		toport.setBounds(380, 25, 70, 25);
		add(entermsg);
		entermsg.setBounds(130, 25, 200, 25);
		add(receivedmsg);
		receivedmsg.setBounds(180, 70, 370, 100);
		add(sentmsg);
		sentmsg.setBounds(180, 185, 370, 100);
		add(send);
		send.setBounds(470, 25, 100, 25);
		add(exit);
		exit.setBounds(250, 300, 100, 25);
		try {
			ds = new DatagramSocket(myport);
		} catch (Exception e) {
			System.out.println(e);
		}
		send.addActionListener(this);
		exit.addActionListener(this);
		new Receive();
	}

	class Receive extends Thread {
		Receive() {
			start();
		}

		public void run() {
			while (true) {
				try {
					byte b[] = new byte[100];
					dp = new DatagramPacket(b, b.length);
					ds.receive(dp);
					receivedmsg
							.append("From "
									+ dp.getPort()
									+ ": "
									+ new String(dp.getData(), 0, dp
											.getLength()) + "n");
				} catch (Exception e) {

				}
			}

		}
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == send) {
			byte b[] = entermsg.getText().getBytes();
			try {
				int port = Integer.parseInt(toport.getText());
				if (port < 1024 || port > 65536) {
					toport.setText("");
					return;
				}
				dp = new DatagramPacket(b, b.length,
						InetAddress.getLocalHost(), port);
				ds.send(dp);
				sentmsg.append("To " + port + ": " + entermsg.getText() + "n");
			} catch (NumberFormatException nfe) {
				toport.setText("Exception");
			} catch (Exception e) {
				toport.setText("Exception");
			}
		} else {
			System.exit(0);
		}
	}

	public static void main(String args[]) {
		new Unicast();
	}

}

class InputDialog extends Dialog implements ActionListener {
	Button ok = new Button("Ok");
	Button cancel = new Button("Cancel");
	TextField tf = new TextField();
	Label l = new Label("Enter the port number:");
	Unicast parent;

	InputDialog(Unicast f) {
		super(f, "Unicast - Port number");
		parent = f;
		setVisible(true);
		setSize(400, 200);
		setLayout(null);
		add(l);
		l.setBounds(25, 50, 200, 25);
		add(tf);
		tf.setBounds(225, 50, 100, 25);
		add(ok);
		ok.setBounds(100, 100, 100, 25);
		add(cancel);
		cancel.setBounds(220, 100, 100, 25);
		ok.addActionListener(this);
		cancel.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == ok) {
			try {
				int n = Integer.parseInt(tf.getText());
				if (n > 1023 && n < 65536) {
					parent.myport = n;
					parent.initialise();
					this.dispose();
				} else {
					tf.setText("");
					tf.requestFocus();
				}
			} catch (NumberFormatException nfe) {
				tf.setText("");
				tf.requestFocus();
			}
		} else if (ae.getSource() == cancel) {
			System.exit(0);
		}

	}
}
