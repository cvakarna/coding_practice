package com.bizruntime.resourcebundle.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyFilesUtil {
	protected static final Logger LOGGER = Logger.getLogger("PropertyFilesUtil");

	private static void writePropertyFile(String propertyFileName, String xmlFileName) {

		LOGGER.debug("Start of writePropertyFile");
		Properties prop = new Properties();
		prop.setProperty("db.host", "localhost");
		prop.setProperty("db.user", "user");
		prop.setProperty("db.pwd", "password");
		try {
			prop.store(new FileWriter(propertyFileName), "DB Config file");
			prop.storeToXML(new FileOutputStream(xmlFileName),"DB Config XML file");
		} catch (FileNotFoundException e) {
			LOGGER.error("FileNotFound Excepition Occured :" + e.getMessage());
		} catch (IOException e) {
			LOGGER.error("IO Exception Occured :" + e.getMessage());
		}
		LOGGER.debug(xmlFileName + " written successfully");
		LOGGER.debug("End of writePropertyFile");

	}

	private static void readPropertyFile(String propertyFileName,
			String xmlFileName) {

		LOGGER.debug("Start of readPropertyFile");
		Properties prop = new Properties();
		FileReader reader = null;
		InputStream is=null;
		try {
			reader = new FileReader(propertyFileName);
			prop.load(reader);
			LOGGER.info(propertyFileName + "::db.host = "	+ prop.getProperty("db.host"));
			LOGGER.info(propertyFileName + "::db.user = "	+ prop.getProperty("db.user"));
			LOGGER.info(propertyFileName + "::db.pwd = "	+ prop.getProperty("db.pwd"));
			LOGGER.info(propertyFileName + "::XYZ = "+ prop.getProperty("XYZ"));

			// loading xml file now, first clear existing properties
			prop.clear();

			is = new FileInputStream(xmlFileName);
			LOGGER.debug(xmlFileName + "::db.host = " + prop.getProperty("db.host"));
			LOGGER.debug(xmlFileName + "::db.user = " + prop.getProperty("db.user"));
			LOGGER.debug(xmlFileName + "::db.pwd = " + prop.getProperty("db.pwd"));
			LOGGER.debug(xmlFileName + "::XYZ = " + prop.getProperty("XYZ"));
			prop.loadFromXML(is);
		} catch (FileNotFoundException e) {
			LOGGER.error("FileNotFound Excepition Occured :" + e.getMessage());
		} catch (InvalidPropertiesFormatException e) {
			LOGGER.error("InvalidPropertiesFormat Excepition Occured :" + e.getMessage());
		} catch (IOException e) {
			LOGGER.error("IOException  Occured :" + e.getMessage());
		}finally{
			// Now free all the resources
			try {
				is.close();
				reader.close();
			}catch (IOException e) {
				LOGGER.error("IOException  Occured :" + e.getMessage());	
			}
		}
		LOGGER.debug("End of readPropertyFile");

	}

	public static void main(String[] args) {
		String propertyFileName = "DB.properties";
		String xmlFileName = "DB.xml";
		writePropertyFile(propertyFileName, xmlFileName);
		readPropertyFile(propertyFileName, xmlFileName);
	}

}
