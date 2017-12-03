package com.threading;

import org.apache.log4j.Logger;

public class ThreadStateTest {
	static Logger log = Logger.getLogger(ThreadStateTest.class);

	public static void main(String[] args) {
		ThreadStateTest example = new ThreadStateTest();
		example.demo();

	}

	private void demo() {
		Thread th = new Thread();
		Object syncObject = new Object();
		ThreadState ts = new ThreadState(syncObject);
		log.debug("Before start() --> ts.isAlive():" + ts.isAlive());
		log.debug("1:" + ts.getState());

		ts.start();
		log.debug("After start()-ts.isAlive():" + ts.isAlive());
		log.debug("2:" + ts.getState());
		ts.setWait(true);
		
		sleepNow(100);
		
			log.debug("3:" + ts.getState());
			ts.setWait(false);
			 
			syncObject.notifyAll();
		
		
		sleepNow(2000);
		log.debug("4:" + ts.getState());
		ts.setKeepRunning(false);

		sleepNow(2000);
		log.debug("5:" + ts.getState());
		log.debug("At the end. ts.isAlive():" + ts.isAlive());
		
	}

	public static void sleepNow(long millis) {
		try {
			Thread.currentThread().sleep(millis);
		} catch (InterruptedException e) {
		}
	}
}
