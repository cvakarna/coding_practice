package com.bizruntime.process;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;


public class ProcessBuilderWithThread {
	private  Logger log = Logger.getLogger(ProcessBuilderWithThread.class);
	public static void main(String[] args) {
		ProcessBuilderWithThread example=new ProcessBuilderWithThread();
		example.createProcess();
	}
	private void createProcess() {
		
		ProcessBuilder pb=new ProcessBuilder("");
		Map<String, String> map=pb.environment();
		Set<Entry<String, String>> set=map.entrySet();
		Iterator<Entry<String, String>> it=set.iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry=it.next();
			log.info(entry.getKey()+" --> "+entry.getValue()+"\n");
		}
		File file=new File("../text1");
		
		log.debug("directory "+pb.directory(file).directory().getAbsolutePath());
		try {
			pb.start();
		} catch (IOException e) {
			log.error("\nWhile starting the process error :  "+e.getMessage());
		}
	}
}
