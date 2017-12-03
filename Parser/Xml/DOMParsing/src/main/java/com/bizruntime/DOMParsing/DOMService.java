package com.bizruntime.DOMParsing;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMService {
static Logger log=Logger.getLogger("DOMService");
	public static void parseXMLFile() {

		try {

			File fXmlFile = new File("src/main/resources/input.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			log.debug("Root element :"+ doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("staff");

			log.info("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				log.debug("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					log.debug("Staff id : "	+ eElement.getAttribute("id"));
					log.debug("First Name : "+ eElement.getElementsByTagName("firstname").item(0).getTextContent());
					log.debug("Last Name : "+ eElement.getElementsByTagName("lastname").item(0).getTextContent());
					log.debug("Nick Name : "+ eElement.getElementsByTagName("nickname").item(0).getTextContent());
					log.debug("Salary : "+ eElement.getElementsByTagName("salary").item(0).getTextContent());

				}
			}
		} catch (Exception e) {
log.error("Exception in "+e.getMessage());
		}

	}

	public static void main(String[] args) {

		
		DOMService.parseXMLFile();
	}
}
