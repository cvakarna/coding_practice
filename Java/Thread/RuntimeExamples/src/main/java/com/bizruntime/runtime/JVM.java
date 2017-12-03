package com.bizruntime.runtime;

import java.io.IOException;

import org.apache.log4j.Logger;

public class JVM {
	private Logger log = Logger.getLogger(DemoRuntime.class);

	public static void main(String[] args) throws IOException {
		JVM example = new JVM();
		example.createProcess();
	}

	private void createProcess() throws IOException {
	
		Runtime runtime=Runtime.getRuntime();
		log.debug("AvailableProcessors --> "+runtime.availableProcessors());
		log.debug("total memory in the Java Virtual Machine --> "+(runtime.totalMemory()/(1024*1024)));
		log.debug("Maximum memory used by  the Java Virtual Machine --> "+(runtime.maxMemory()/(1024*1024)));
		log.debug("free memory in the Java Virtual Machine --> "+(runtime.freeMemory()/(1024*1024)));
		
		
	}
}
