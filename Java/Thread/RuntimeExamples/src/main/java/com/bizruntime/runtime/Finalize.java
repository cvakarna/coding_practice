package com.bizruntime.runtime;

import java.io.IOException;

import org.apache.log4j.Logger;

public class Finalize {
	private Logger log = Logger.getLogger(Finalize.class);

	public static void main(String[] args) throws IOException {
		Finalize example = new Finalize();
		example.createProcess();
	}

	private void createProcess() throws IOException {
		new Finalize();
		for(int i =0;i<1000;i++)
	    {
			Finalize construct = new Finalize();
	        construct = null;
	    }
Runtime runitme=Runtime.getRuntime();
		runitme.gc();
//		System.gc();
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		log.debug("Object Destroyed");
	}
}
