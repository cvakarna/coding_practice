package com.bizruntime.process;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class ListPrograms {
	private Logger log = Logger.getLogger(ListPrograms.class);

	public static void main(String[] args) throws IOException {
		ListPrograms example = new ListPrograms();
		example.createProcess();
	}

	private void createProcess() throws IOException {

		ProcessBuilder pb = new ProcessBuilder("/bin/bash","/usr/bin/google-chrome");
		List<String> list = pb.command();
		for (String s : list)
			log.debug(s + "\n");
		System.out.println("Configure parameters");
		
		Map<String, String> env = pb.environment();

		env.put("name", "google");

		env.put("echoCount", "2");

		System.out.println("Redirect output and error to file");
		
		File outputFile = new File("src/resources/PingLog1.txt");
		File errorFile = new File("src/resources/PingErrLog.txt");
		outputFile.getParentFile().mkdirs();
		try {
			if(!outputFile.exists())
				outputFile.createNewFile();
			if(!outputFile.exists())
			errorFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		pb.redirectOutput(outputFile);

		pb.redirectError(errorFile);
		try {
			Process p = pb.start();
			
		} catch (IOException e) {
			log.error("IOException : " + e.getMessage());
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		printFile(outputFile);
		printFile(errorFile);
	
		System.out.println("RedirectError() -> "+pb.redirectError());
		System.out.println(pb.redirectErrorStream());
		
	}
	 private  void printFile(File file) throws IOException {
		 FileReader fr = new FileReader(file);
		  BufferedReader br = new BufferedReader(fr);
	        String line;
	        
	        while ((line = br.readLine()) != null) {
	            System.out.println(line);

	        }
		  br.close();
		  fr.close();
	 }
}
