package com.bizruntime.security;

import java.io.IOException;

import org.apache.log4j.Logger;

public class Example1 {
	private Logger log = Logger.getLogger(Example1.class);

	public static void main(String[] args) throws IOException {
		Example1 example = new Example1();
		example.createProcess();
	}

	private void createProcess() throws IOException {
System.out.println(System.getSecurityManager());		
	}
}
