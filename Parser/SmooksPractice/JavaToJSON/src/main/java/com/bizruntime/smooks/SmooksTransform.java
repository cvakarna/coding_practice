package com.bizruntime.smooks;


import java.io.IOException;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.milyn.Smooks;
import org.milyn.SmooksException;
import org.milyn.container.ExecutionContext;
import org.milyn.json.JSONReader;
import org.milyn.payload.JavaSource;
import org.xml.sax.SAXException;

import com.smooks.model.Order;




public class SmooksTransform {
   private static Logger LOGGER =Logger.getLogger("SmooksTransform");



   protected String runSmooksTransform(Object o) throws IOException, SAXException, SmooksException {
	   Smooks smooks = null;
		StringWriter writer = null;
		try {

			smooks = new Smooks("smooks-config.xml");
			ExecutionContext executionContext = smooks.createExecutionContext();
            writer = new StringWriter();

            smooks.filterSource(executionContext, new JavaSource(o), new StreamResult(writer));
		} catch (IOException e) {

			LOGGER.error(e.getMessage());
		} catch (SAXException e) {

			LOGGER.error(e.getMessage());
		} 
		return writer.toString();
	}

   public static void main(String[] args) throws IOException, SAXException, SmooksException {
	   
	   SmooksTransform transform=new SmooksTransform();
	   Order javaInput = new Order();
	   String transResult = transform.runSmooksTransform(javaInput);;
	
     LOGGER.info(transResult);
   }

   



}
