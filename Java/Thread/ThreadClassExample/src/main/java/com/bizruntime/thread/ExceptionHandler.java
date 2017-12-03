package com.bizruntime.thread;

import java.lang.Thread.UncaughtExceptionHandler;

import org.apache.log4j.Logger;

public class ExceptionHandler {
	private  Logger log = Logger.getLogger(ExceptionHandler.class);

	public static void main(String[] args) {
		ExceptionHandler method=new ExceptionHandler();
		method.threadCreation();
		
	}

	private void threadCreation() {
		Thread th=new Thread(new D());

		UncaughtExceptionHandler handler= (Thread t, Throwable e)-> {System.out.println("Error occured");};
		th.setDefaultUncaughtExceptionHandler(handler);
		log.debug("default handller class   -> "+th.getDefaultUncaughtExceptionHandler());
		th.start();
	}
}

class D implements Runnable{
	private static Logger log = Logger.getLogger(D.class);

	@Override
	public void run() {
		
		log.debug("D class Run method called");
		throw new RuntimeException();
	}
}