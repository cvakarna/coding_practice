package com.threadlocal;

import org.apache.log4j.Logger;

public class Example {
	private Logger log = Logger.getLogger(Example.class);

	private ThreadLocal<Integer> th = ThreadLocal.withInitial(() -> 100);

	public static void main(String[] args) {
		Example example = new Example();
		example.demo();
	}

	private void demo() {
		new Thread(new Example()::run).start();
		new Thread(new Example()::run).start();
		new Thread(new Example()::run).start();

	}

	private void run() {
		for (int i = 0; i < 5; i++) {
			th.set(th.get() + 1);
			log.debug("Thread : " + Thread.currentThread().getName() + " "
					+ th.get());
		}
	}
}