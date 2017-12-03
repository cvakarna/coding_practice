package com.forkjoin;

import java.util.concurrent.ForkJoinPool;

import org.apache.log4j.Logger;

public class Example {
	private Logger log = Logger.getLogger(Example.class);

	public static void main(String[] args) {
		Example example = new Example();
		example.demo();
	}

	private void demo() {
		ForkJoinPool pool = new ForkJoinPool();
		RandomIntSum task = new RandomIntSum(3);
		
		long sum = pool.invoke(task);
	
		log.info("Sum is : "+sum);
	}
}
