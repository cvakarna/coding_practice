package com.bizruntime.thread;

import org.apache.log4j.Logger;

public class Sample {
	private  Logger log = Logger.getLogger(Sample.class);

	public static void main(String[] args) {

		Sample sample=new Sample();
		sample.test();
		
	}

	

	private void test() {
		log.debug("STATE --> " + Thread.State.BLOCKED);
		log.debug("MAX.PRIORITY --> " + Thread.MAX_PRIORITY);
		log.debug("MIN.PRIORITY --> " + Thread.MIN_PRIORITY);
		log.debug("NORM.PRIORITY --> " + Thread.NORM_PRIORITY);

		
		Sample sample=new Sample();
		sample.zeroArgConstructor();
		sample.oneArgConstructor(new B());
		String name1="Custom-Thread1";
		sample.oneArgConstructor(name1);
		
		ThreadGroup tg1 = new ThreadGroup("GroupA");
		sample.twoArgConstructor(tg1,new B());
		
		String name2="Custom-Thread2";
		sample.twoArgConstructor(new B(),name2);
		
		ThreadGroup tg2=new ThreadGroup("GroupB");
		sample.twoArgConstructor(tg2,"custome-thread-3");
		
		ThreadGroup tg3=new ThreadGroup("GroupB");
		sample.threeArgConstructor(tg2,new B(),"custome-thread-4");
		
		sample.fourArgConstructor(tg3,new B(),"custome-thread-3",20l);
		
		
		
	}



	private void fourArgConstructor(ThreadGroup tg3, Runnable r, String string, long l) {
		
		Thread th3 = new Thread(tg3, r,string,l);
		log.debug("Thread name create by default --> " + th3.getName());
		log.debug("Threadgroup --> " + th3.getThreadGroup());
		log.debug("Get Priority --> " + th3.getPriority());

	}



	private void threeArgConstructor(ThreadGroup tg2, Runnable r, String string) {
		
		Thread th3 = new Thread(tg2,r, string);
		log.debug("Thread name create by default --> " + th3.getName());
		log.debug("Threadgroup --> " + th3.getThreadGroup());
		log.debug("Get Priority --> " + th3.getPriority());
		
	}



	private void twoArgConstructor(ThreadGroup tg2, String string) {
		Thread th3 = new Thread(tg2, string);
		log.debug("Thread name create by default --> " + th3.getName());
		log.debug("Threadgroup --> " + th3.getThreadGroup());
		log.debug("Get Priority --> " + th3.getPriority());
		
	}



	public void zeroArgConstructor() {

		Thread th1 = new Thread();
		log.debug("Thread name create by default --> " + th1.getName());
		log.debug("Get Priority" + th1.getPriority());

	}

	public void oneArgConstructor(Runnable r) {
		Thread th2 = new Thread(r);
		log.debug("Thread name create by default --> " + th2.getName());
		log.debug("Threadgroup --> " + th2.getThreadGroup());
		log.debug("Get Priority" + th2.getPriority());

	}
	
	private void oneArgConstructor(String name) {
		
		Thread th2 = new Thread(name);
		log.debug("Thread name changed --> " + th2.getName());
		log.debug("Threadgroup --> " + th2.getThreadGroup());
		log.debug("Get Priority" + th2.getPriority());
		
	}
	public void twoArgConstructor(ThreadGroup tg,Runnable r) {
		Thread th3 = new Thread(tg, r);
		log.debug("Thread name create by default --> " + th3.getName());
		log.debug("Threadgroup --> " + th3.getThreadGroup());
		log.debug("Get Priority --> " + th3.getPriority());
		log.debug("Threadgroup parent --> " + tg.getParent().getParent());

	}

	
	private void twoArgConstructor(Runnable r, String name) {
		Thread th3 = new Thread(r, name);
		log.debug("Thread name create by default --> " + th3.getName());
		log.debug("Threadgroup --> " + th3.getThreadGroup());
		log.debug("Get Priority --> " + th3.getPriority());
		
	}
}

class A extends Thread {

	private  Logger log = Logger.getLogger(A.class);

}

class B implements Runnable {
	private  Logger log = Logger.getLogger(B.class);

	@Override
	public void run() {
		log.debug("Class B run() method called. ");
	}
}