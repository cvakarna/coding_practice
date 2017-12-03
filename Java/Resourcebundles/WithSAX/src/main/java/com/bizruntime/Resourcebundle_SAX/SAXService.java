package com.bizruntime.Resourcebundle_SAX;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SAXService {
static Logger log=Logger.getLogger("SAXService");
public static final String PATH="path";
public static final String DATA_SOURCE="Resource.properties";

	public static void parseXMLFile() {

		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

				boolean bfname,blname,bnname,bsalary ;
				public void startElement(String uri, String localName,String qName, Attributes attributes)
						throws SAXException {

					log.debug("Start Element :" + qName);

					if (qName.equalsIgnoreCase("FIRSTNAME")) {
						bfname = true;
					}

					if (qName.equalsIgnoreCase("LASTNAME")) {
						blname = true;
					}

					if (qName.equalsIgnoreCase("NICKSAXNAME")) {
						bnname = true;
					}

					if (qName.equalsIgnoreCase("SALARY")) {
						bsalary = true;
					}

				}

				public void endElement(String uri, String localName,String qName) throws SAXException {

					log.debug("End Element :" + qName);

				}

				public void characters(char ch[], int start, int length)
						throws SAXException {

					if (bfname) {
						log.debug("First Name : "+ new String(ch, start, length));
						bfname = false;
					}

					if (blname) {
						log.debug("Last Name : "+ new String(ch, start, length));
						blname = false;
					}

					if (bnname) {
						log.debug("Nick Name : "+ new String(ch, start, length));
						bnname = false;
					}

					if (bsalary) {
						log.debug("Salary : "+ new String(ch, start, length));
						bsalary = false;
					}

				}

			};

			Properties prop = new Properties();

	        InputStream input = SAXService.class.getClassLoader()
	                .getResourceAsStream(SAXService.DATA_SOURCE);
	        
	            prop.load(input);
				saxParser.parse(prop.getProperty(SAXService.PATH), handler);

	     
	        

		} catch (Exception e) {
			log.error("Exception"+e.getMessage());
		}
	}

	public static void main(String[] args) {
		

		SAXService.parseXMLFile();
		
	}
}
