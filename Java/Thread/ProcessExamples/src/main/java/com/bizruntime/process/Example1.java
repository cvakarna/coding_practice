package com.bizruntime.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;


public class Example1 {
	private  Logger log = Logger.getLogger(Example1.class);

	
	public static void main(String[] args) {
		
		Example1 example=new Example1();
		example.createProcess();
		//example.getSystemVariables();
	}


	private void getSystemVariables() {
		Map<String, String> map=System.getenv();
		Set<Entry<String, String>> set=map.entrySet();
		Iterator<Entry<String, String>> it=set.iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry=it.next();
			log.info(entry.getKey()+" --> "+entry.getValue());
			
		}
	}


	private void createProcess() {
	
		try {
			ProcessBuilder pb = new ProcessBuilder("/bin/bash", "/usr/bin/google-chrome","www.facebook.com","www.google.com/?q=bizruntime");
			//pb.directory(...);
			pb.redirectErrorStream(true);
	
			Process p = pb.start();
	
			//IOUtils.copy(p.getInputStream(), System.out);
			
			ProcessBuilder pb1=pb.command("echo","Testing");
			
			Process p1=pb1.start();
			p.waitFor();
			read(p1.getInputStream());
			} catch (IOException e) {
			log.error("process not found "+ e.getMessage());
			}catch(InterruptedException e){
				log.error("Interrupted Exception  "+ e.getMessage());
			}
		
	}
	
	public void read(InputStream is) throws IOException{
		System.out.println(is.read());
			try {
				byte by=(byte)is.read();
				while(by!=-1){
					log.debug((char)by);
					by=(byte)is.read();
					
				}
				is.close();
			} catch (IOException e) {
				log.error("IoException Occured : "+e.getMessage());
			}
			
			System.out.println("test");
			
	}
}
