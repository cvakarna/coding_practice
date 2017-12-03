package com.bizruntime.thread;

import org.apache.log4j.Logger;

public class DaemonMethod {
	private  Logger log = Logger.getLogger(DaemonMethod.class);

	public static void main(String[] args) {
		DaemonMethod method=new DaemonMethod();
		method.threadCreation();
		
	}

	private void threadCreation() {
		Thread th1=new Thread(new A1());
		th1.setDaemon(true);
		
		try{
		th1.checkAccess();
		}catch(SecurityException e){
			log.debug(e.getMessage());
		}
		if(th1.isDaemon()){
			log.debug("Thread 1 is a daemon ");
			log.debug("Priority -> "+th1.getPriority());
		}else{
			log.debug("Thread 1 is not a daemon ");
		}
		
		th1.start();
		
	}

}
