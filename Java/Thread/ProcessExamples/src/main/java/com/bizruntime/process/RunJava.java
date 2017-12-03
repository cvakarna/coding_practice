package com.bizruntime.process;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import org.apache.log4j.Logger;


public class RunJava {
	private Logger log = Logger.getLogger(RunJava.class);

	public static void main(String[] args) throws IOException {
		RunJava example = new RunJava();
		example.createProcess();
	}

	private void createProcess() throws IOException {

//	ProcessBuilder pb = new ProcessBuilder("/usr/bin/javac","src/main/java/com/bizruntime/process/Add2Numbers.java");
		
		ProcessBuilder pb = new ProcessBuilder("/usr/bin/java","com.bizruntime.process.Add2Numbers");
		
		File inputFile = new File("src/resources/PingInput.txt");
		File outputFile = new File("src/resources/PingLog1.txt");
		File errorFile = new File("src/resources/PingErrLog.txt");
		outputFile.getParentFile().mkdirs();
		try {
			if(!outputFile.exists())
				outputFile.createNewFile();
			if(!errorFile.exists())
			errorFile.createNewFile();
			if(!inputFile.exists())
				inputFile.createNewFile();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		pb.redirectInput(Redirect.from(inputFile));
		pb.redirectOutput(Redirect.to(outputFile));
		pb.redirectOutput(ProcessBuilder.Redirect.appendTo(outputFile));
		pb.redirectError(ProcessBuilder.Redirect.appendTo(errorFile));
//		pb.redirectError(Redirect.INHERIT);
		pb.redirectOutput(Redirect.INHERIT);
		
//		pb.inheritIO();
		Process p=pb.start();
		
		try {
			int exitValue = p.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	
}
