package com.threading;

import org.apache.log4j.Logger;

public class Example2 {

	public static Logger log = Logger.getLogger(Example2.class);

	public static int balance = 100;

	public static void main(String[] args) {
		Example2 example = new Example2();
		example.demo();
	}

	private void demo() {
		startBalanceUpdateThread();
		startBalanceMonitorThread();

	}

	public static void startBalanceMonitorThread() {
		Thread t = new Thread(() -> {
			while (true) {
				
				updateBalance();
			}
		});
		t.start();
	}

	public synchronized static void updateBalance() {

		balance = balance + 10;

		balance = balance - 10;
	}

	static void startBalanceUpdateThread() {
		Thread t = new Thread(() -> {
			while (true) {
				
				monitorBalance();
			}
		});
		t.start();
	}

	public synchronized static void monitorBalance() {

		int b = balance;
		if (b != 100) {
			log.debug("Balance changed: " + b);
			System.exit(1); 
		}
	}

}
