package com.bizruntime.thread;

import java.io.IOException;

import org.apache.log4j.Logger;

public class InterruptMethod {
	private  Logger log = Logger.getLogger(InterruptMethod.class);

	public static void main(String[] args) {
		InterruptMethod method=new InterruptMethod();
		method.threadCreation();
		
	}

	private void threadCreation() {
		Thread th1=new Thread(new A1());
		Thread th2=new Thread(new A1());
		
		th1.start();
		try {
		//	th1.join();
		//	th1.join(10);
			th1.join(0,1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}catch(Exception e){
			Thread.dumpStack();	
		}
		th2.start();
		
		System.out.println("main thread finished");
	}
	
}
class A1 implements Runnable{
	private static Logger log = Logger.getLogger(A1.class);

	@Override
	public void run() {
		log.debug("A1 class run method called");
		for (int i = 0; i < 100; i++) {
			
			log.debug(Thread.currentThread().getName()+" "+i);
			try{
				
				throw new IOException();
			}catch(Exception e){
				log.debug("finally block");
				
			}finally{
				log.debug("finally block");
			}
		}
	}
}
