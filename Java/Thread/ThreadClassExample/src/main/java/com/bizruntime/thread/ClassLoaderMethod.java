package com.bizruntime.thread;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.log4j.Logger;

public class ClassLoaderMethod {
	private  Logger log = Logger.getLogger(ClassLoaderMethod.class);

	public static void main(String[] args) {
		ClassLoaderMethod method=new ClassLoaderMethod();
		method.threadCreation();
		
	}

	private void threadCreation() {
		Thread th=new Thread(new B1());
		log.debug(Thread.class.getClassLoader());
		log.debug("B1 class thread class loader"+th.getContextClassLoader());
		th.start();
	}
}

class B1 implements Runnable{
	private  Logger log = Logger.getLogger(B1.class);

	@Override
	public void run() {
		log.debug("B1 class Run method called");
		Thread th=new Thread(new C1());
		ClassLoader prevCl = Thread.currentThread().getContextClassLoader();
		try {
			ClassLoader urlCl = URLClassLoader.newInstance(new URL[]{new URL("www.google.com")}, prevCl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("B1 class thread class loader"+th.getContextClassLoader());
		log.debug("C1 class thread class loader"+th.getContextClassLoader().getResource("log4j.properties"));
		th.start();
	}
}
class C1  implements Runnable{
	private  Logger log = Logger.getLogger(C1.class);

	@Override
	public void run() {
		log.debug("C1 class Run method called");
	}
}