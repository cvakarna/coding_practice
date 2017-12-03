package com.bizruntime.socket;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.JFrame;

public class Multicast extends JFrame implements ActionListener, Runnable {
	Label entermsgl, receivedmsgl, sentmsgl;
	TextField entermsg;
	TextArea receivedmsg, sentmsg;
	Button Multicast, exit;
	int myport;
	MulticastSocket ms_send, ms_receive;
	DatagramPacket dp;
	InetAddress address;
	Thread t;

	Multicast() {
		initialise();
	}

	public void initialise() {
		setTitle("Multicast ");
		setVisible(true);
		setSize(600, 400);
		entermsgl = new Label("Enter Message:");
		receivedmsgl = new Label("Received Messages:");
		sentmsgl = new Label("Sent Messages:");
		entermsg = new TextField();
		receivedmsg = new TextArea();
		sentmsg = new TextArea();
		Multicast = new Button("Multicast");
		exit = new Button("Exit");
		setLayout(null);
		add(entermsgl);
		entermsgl.setBounds(25, 25, 100, 25);
		add(receivedmsgl);
		receivedmsgl.setBounds(25, 70, 150, 25);
		add(sentmsgl);
		sentmsgl.setBounds(25, 185, 150, 25);
		add(entermsg);
		entermsg.setBounds(130, 25, 200, 25);
		add(receivedmsg);
		receivedmsg.setBounds(180, 70, 370, 100);
		add(sentmsg);
		sentmsg.setBounds(180, 185, 370, 100);
		add(Multicast);
		Multicast.setBounds(470, 25, 100, 25);
		add(exit);
		exit.setBounds(250, 300, 100, 25);
		try {
			address = InetAddress.getByName("224.2.2.2");
			System.out.println(address.getHostName());
			ms_send = new MulticastSocket();
			ms_receive = new MulticastSocket(2001);
			ms_receive.joinGroup(address);
		} catch (Exception e) {
			System.out.println(e);
		}
		Multicast.addActionListener(this);
		exit.addActionListener(this);
		t = new Thread(this);
		t.start();
	}

	// class Receive extends Thread{
	// Receive(){
	// start();
	// }
	public void run() {
		while (true) {
			System.out.println("1");
			try {
				DatagramPacket dp1;
				byte b[] = new byte[105];
				System.out.println("2");

				dp1 = new DatagramPacket(b, b.length);
				ms_receive.receive(dp1);

				for (int i = 0; i < b.length; i++)
					System.out.println(b[i]);
				System.out.println("3");

				receivedmsg.append("From " + dp1.getAddress() + " "
						+ dp1.getPort() + ": "
						+ new String(dp1.getData(), 0, dp1.getLength()) + "\n");
				repaint();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	// }
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == Multicast) {
			byte b[] = entermsg.getText().getBytes();
			try {
				dp = new DatagramPacket(b, b.length, address, 2001);
				ms_send.send(dp, (byte) 1);
				sentmsg.append(ms_send.getLocalAddress() + " port:"
						+ ms_send.getLocalPort() + ": " + entermsg.getText()
						+ "\n");
			} catch (NumberFormatException nfe) {
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			System.exit(0);
		}
	}

	public static void main(String args[]) {
		new Multicast();
	}

}
