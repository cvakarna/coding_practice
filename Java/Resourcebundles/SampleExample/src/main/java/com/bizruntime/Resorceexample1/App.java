package com.bizruntime.Resorceexample1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {
	public static Logger logger = Logger.getLogger("App");
	public static byte[] outputStream;

	public static void inputStreamReader() throws IOException {
		InputStream input = App.class.getClassLoader().getResourceAsStream(
				"data.properties");
		Properties properties = new Properties();
		try {
			properties.load(input);

			logger.debug("name :" + properties.getProperty("name"));
			logger.debug("location: " + properties.getProperty("place"));
			logger.debug("phone :" + properties.getProperty("phone"));

		} catch (FileNotFoundException e) {
			logger.error("File not Found Exeption :" + e.getMessage());
		}
		

	}

	public static void main(String[] args) throws IOException {
		App app = new App();
		app.inputStreamReader();

	}

}
