package com.bizruntime.threadlocal;

import org.apache.log4j.Logger;

public class Sample {
	private  Logger log = Logger.getLogger(Sample.class);

	public static void main(String[] args) {
		Sample method=new Sample();
		method.threadCreation();
		
	}

	private void threadCreation() {
		MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        try {
			thread1.join();
	        thread2.join();
		} catch (InterruptedException e) {
        	log.error("Interrupted Exception Occurred : "+e.getMessage());

		} 
	}
}

class MyRunnable implements Runnable{
	private  Logger log = Logger.getLogger(Sample.class);

	private ThreadLocal<Integer> threadLocal =new ThreadLocal<Integer>();
	
	@Override
	public void run() {
		threadLocal.set( (int) (Math.random() * 100D) );

		try {
			log.debug(Thread.currentThread().getName()+" Thread going to sleep state");
            Thread.sleep(2000);
            log.debug(Thread.currentThread().getName()+" Thread back from sleep state");
        } catch (InterruptedException e) {
        	log.error("Interrupted Exception Occurred : "+e.getMessage());
        }

        log.info("Local variable value --> "+threadLocal.get());
    
	}
}
