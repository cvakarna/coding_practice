package com.bizruntime.threadlocal;

import org.apache.log4j.Logger;

public class A {
	private  Logger log = Logger.getLogger(A.class);

	public static void main(String[] args) {
		A a=new A();
		a.doSomething();
	}

	private void doSomething() {
		Thread th=new Thread(new CustomDate());
		
	}
}
