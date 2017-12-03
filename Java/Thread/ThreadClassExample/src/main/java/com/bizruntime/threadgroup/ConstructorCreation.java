package com.bizruntime.threadgroup;

import org.apache.log4j.Logger;

public class ConstructorCreation {
	private  Logger log = Logger.getLogger(ConstructorCreation.class);

	public static void main(String[] args) {
		ConstructorCreation method=new ConstructorCreation();
		method.threadCreation();
		
	}

	private void threadCreation() {
		ThreadGroup tg=new ThreadGroup("parent");
		tg.setMaxPriority(1);
		ThreadGroup tg1=new ThreadGroup(tg,"child");
		log.debug(tg.getName()+"\'s parent is "+tg.getParent().getName());
		log.debug(tg1.getName()+"\'s parent is "+tg1.getParent().getName());
		
		Thread th=new Thread(tg,new A());
		th.start();
		log.debug("Total threads running in ThreadGroup parent : "+tg.activeCount());
		log.debug("Total threadgroup count parent and its sub groups : "+tg.activeGroupCount());
		
		
		Thread []th1=new Thread[3];
		th1[0]=new Thread(new A());
		th1[1]=new Thread(new A());
		th1[1]=new Thread(new A());

		tg.enumerate(th1);
		log.info(th1[0].getThreadGroup());
		
		tg.setDaemon(true);
		
		log.debug("Is threadgroup parent is daemon --> "+tg.isDaemon());
		
		
		log.debug("Is thread th1[0] under threadgroup parent is daemon --> "+th1[0].isDaemon());
		
		
		log.debug("parent threadgroup  is a parent of  child threadgroup  --> "+tg.parentOf(tg1));
		log.debug("child threadgroup  is a parent of  parent threadgroup  --> "+tg1.parentOf(tg));

	}
}

class A implements Runnable{
	private static Logger log = Logger.getLogger(A.class);
	@Override
	public void run() {
		
		log.debug("run () called ");
	}
}