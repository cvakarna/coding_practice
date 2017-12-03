package com.bizruntime.smooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.io.StreamUtils;
import org.milyn.payload.JavaResult;
import org.milyn.payload.StringSource;
import org.xml.sax.SAXException;

public class SmooksTransform {
	private static Logger LOGGER = Logger.getLogger("SmooksTransform");

	public static void main(String[] args) {

	
		LOGGER.debug( (List)SmooksTransform.runSmooksTransform());
	}

	private static String readInputMessage() {
		try {
			return StreamUtils.readStreamAsString(new FileInputStream(
					"src/main/resources/input.csv"));
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			return "<no-message/>";
		}
	}

	private static String messageIn = readInputMessage();

	protected static Object runSmooksTransform() {

		Smooks smooks = null;
		try {
			smooks = new Smooks("smooks-config.xml");

			ExecutionContext executionContext = smooks.createExecutionContext();
			JavaResult result = new JavaResult();

			smooks.filterSource(executionContext, new StringSource(messageIn),
					result);

			return result.getBean("customerList");
		} catch (IOException e) {

			return ""+e.getMessage();
		} catch (SAXException e) {

			return e.getMessage();
		} finally {
			smooks.close();
		}

	}
}