package com.bizruntime.thread;

import org.apache.log4j.Logger;

public class ThreadClassMethods {
	private  Logger log = Logger.getLogger(ThreadClassMethods.class);
	
	public static void main(String[] args) {
		
		ThreadClassMethods example=new ThreadClassMethods();
	//	example.currentThread();
		
		/*log.debug("Thread going to sleep  ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		log.debug("Thread back from sleep ");

		log.debug("Thread going to sleep for n nano seconds ");
		try {
			Thread.sleep(0,10000);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		log.debug("Thread back from sleep ");
*/		
		
		
		example.yield();
		
	}

	private void yield() {
		 Thread th1 = new Thread(new C(),"thread-A");
		 Thread th2 = new Thread(new C(),"thread-B");

		 th1.start();
		 th2.start();
		
		
	}

	private void currentThread() {
		 Thread th1 = new Thread();
		 th1.start();
		log.debug("Thread after thread creation --> " + th1.currentThread());
	}
	
	
}

class C implements Runnable{
	private static Logger log = Logger.getLogger(C.class);

	@Override
	public void run() {
		String name= Thread.currentThread().getName();
		log.debug("Current Thread "+name);
		
		for (int i = 0; i < 10; i++) {
			if(i==5 && (name.equals("thread-A"))){
				 log.debug("Thread A going to yield state... ");
				Thread.yield();
				 log.debug("Thread A back from yield state... ");
			}
			log.info(name+" --> "+i);
		}
		 log.debug("Thread " +name+" finished executing");
	}
	
}