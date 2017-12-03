package com.threading.example;

import java.util.Random;

import org.apache.log4j.Logger;


public class Producer extends Thread{
	public Logger log = Logger.getLogger(Producer.class);
	private Buffer buffer;
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		Random rand = new Random();
		while (true) {
			int n = rand.nextInt();
			buffer.produce(n);
		}

	}
}
