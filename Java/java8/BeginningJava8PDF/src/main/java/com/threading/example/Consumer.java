package com.threading.example;

import org.apache.log4j.Logger;

public class Consumer extends Thread {

	public Logger log = Logger.getLogger(Producer.class);

	private Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		int data;
		while (true) {
			data = buffer.consume();
		}
	}
}
