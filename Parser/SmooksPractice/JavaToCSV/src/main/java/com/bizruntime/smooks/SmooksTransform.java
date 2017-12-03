package com.bizruntime.smooks;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.payload.JavaSource;
import org.xml.sax.SAXException;

public class SmooksTransform {
	   private static Logger LOGGER =Logger.getLogger("SmooksTransform");

	 protected String runSmooksTransform(Object inputJavaObject) throws IOException, SAXException {
		 Smooks smooks = new Smooks("smooks-config.xml");

	        try {
	            ExecutionContext executionContext = smooks.createExecutionContext();
	            StringWriter writer = new StringWriter();

	            smooks.filterSource(executionContext, new JavaSource(inputJavaObject), new StreamResult(writer));

	            return writer.toString();
	        } finally {
	            smooks.close();
	        }
	    }
	 public static void main(String[] args)  {

	        getResult();
	    }

	 static void getResult() {
		 SmooksTransform exampleMain = new SmooksTransform();

		 Customer customer = new Customer();
	        customer.setFirstName("Maciej");
	        customer.setLastName("Dobrowolski");
	        customer.setAge(23);

	        String translateResults = null;

	        try {
				translateResults = exampleMain.runSmooksTransform(customer);
			} catch (IOException e) {
			LOGGER.error(e.getMessage());
			} catch (SAXException e) {
				LOGGER.error(e.getMessage());
			}

	        LOGGER.debug(translateResults);

	 }
}
