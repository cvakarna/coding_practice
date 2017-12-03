package com.bizruntime.Resorceexample1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


	public class Test{
		public static void main(String args[]) {
		// loading resource using getResourceAsStream() method
		InputStream in = Test.class.getClassLoader().getResourceAsStream("data.properties");
		Properties config = new Properties();
		try {  
			config.load(in); 
			System.out.println(config.getProperty("name"));
			System.out.println(config.getProperty("place")); 
			} catch (IOException e1) { 
				e1.printStackTrace();
				} 
// loading resource using getResource() method
		URL resourceURL = Test.class.getResource("app.properties");
		Properties appConfig = new Properties();
		try {
			appConfig.load(resourceURL.openStream());
			System.out.println(appConfig.getProperty("name"));
			System.out.println(appConfig.getProperty("version")); 
			} catch (IOException e) {
				e.printStackTrace(); } } } 
	}
}
}
