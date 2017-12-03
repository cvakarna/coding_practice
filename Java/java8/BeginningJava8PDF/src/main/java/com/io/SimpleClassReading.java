package com.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;

public class SimpleClassReading {
	Logger log = Logger.getLogger(SimpleClassReading.class);

	public static void main(String[] args) {
		SimpleClassReading example = new SimpleClassReading();
		example.demo();
	}

	private void demo() {

		String dataSourceFile = "text.txt";
		try (FileInputStream fin = new FileInputStream(dataSourceFile)) {
			byte byteData;
			while ((byteData = (byte)fin.read()) != -1) {		
				log.debug((char) byteData);
			}
			BufferedInputStream d=new BufferedInputStream(fin);
			String lineSeparator = System.getProperty("line.separator");
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
}
