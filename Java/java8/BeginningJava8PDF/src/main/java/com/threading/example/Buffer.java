package com.threading.example;

import org.apache.log4j.Logger;

public class Buffer {
	public Logger log = Logger.getLogger(Buffer.class);

	private int data;
	private boolean empty;

	public Buffer() {
		this.empty = true;
	}

	public synchronized void produce(int newData) {
		while (!this.empty) {
			System.out.println(this.empty);
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.data = newData;
		this.empty = false;
		this.notify();
		log.debug("Produced:" + newData);
	}

	public synchronized int consume() {
		while (this.empty) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.empty = true;
		this.notify();
		log.debug("Consumed:" + data);
		return data;
	}
}
