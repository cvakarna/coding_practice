package com.models;

import java.util.concurrent.atomic.AtomicInteger;

public class Sequence {
	private static final AtomicInteger counter = new AtomicInteger(10000);

	public  int nextValue() {
	    return counter.getAndIncrement();
	  }

}
