package com.bizruntime.security;

import java.io.IOException;

import org.apache.log4j.Logger;


public class Example {

	private Logger log = Logger.getLogger(Example.class);

	public static void main(String[] args) throws IOException {
		Example example = new Example();
		example.createProcess();
	}

	private void createProcess() throws IOException {
		SecurityManager sec=new SecurityManager();
		
		log.debug(sec.getSecurityContext());
		log.debug(sec);
		System.setSecurityManager(sec);
		log.debug(System.getSecurityManager());
		log.debug(sec.getSecurityContext());
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
