package com.bizruntime.SAXParsing;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXService {
static Logger log=Logger.getLogger("SAXService");
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

					if (qName.equalsIgnoreCase("NICKNAME")) {
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

			saxParser.parse("src/main/resources/input.xml", handler);

		} catch (Exception e) {
			log.error("Exception"+e.getMessage());
		}
	}

	public static void main(String[] args) {
		
		log.info("Hello World!");
		SAXService.parseXMLFile();
		
	}
}
