package com.bizruntime.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;


public class RuntimeExcetue {
	private Logger log = Logger.getLogger(RuntimeExcetue.class);

	public static void main(String[] args) throws IOException {
		RuntimeExcetue example = new RuntimeExcetue();
		example.createProcess();
	}

	private void createProcess() throws IOException {
		Runtime runtime = Runtime.getRuntime();
	      Process process = runtime.exec("/bin/bash /usr/bin/google-chrome");
	      InputStream is = process.getInputStream();
	     
	      InputStreamReader isr = new InputStreamReader(is);
	      BufferedReader br = new BufferedReader(isr);
	      String line;
	 
	      
	      while ((line = br.readLine()) != null) {
	        log.debug(line);
	      }
	   
	}
}
