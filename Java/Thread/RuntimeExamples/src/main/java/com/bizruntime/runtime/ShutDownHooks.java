package com.bizruntime.runtime;

import java.io.IOException;

import org.apache.log4j.Logger;

public class ShutDownHooks {
	private static Logger log = Logger.getLogger(ShutDownHooks.class);

	public static void main(String[] args) throws IOException {
		ShutDownHooks example = new ShutDownHooks();
		example.createProcess();
		log.debug("End of main() ");
		
	}

	private void createProcess() throws IOException {
	
		Runtime runtime=Runtime.getRuntime();
		runtime.addShutdownHook(new Thread(){
			@Override
			public void run() {
				log.debug("Shutdown hook called ");
				log.debug("Going to do some operations before jvm shutdowns...");
				System.err.println("wait for sometimes......");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					log.error(" Error occurred  "+e.getMessage());
				}
				
				log.debug("Process finshed. JVM going to shutdown");
			} 
		});
			
		log.debug("End of CreateProcess() ");
		runtime.halt(0);
	}
}
