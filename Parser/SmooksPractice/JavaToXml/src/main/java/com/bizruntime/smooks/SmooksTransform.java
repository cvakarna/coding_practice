package com.bizruntime.smooks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.payload.JavaSource;
import org.xml.sax.SAXException;

import com.smooks.models.Order;

public class SmooksTransform {
	private static Logger LOGGER = Logger.getLogger("SmooksTransform");

	protected String runSmooksTransform(Object inputJavaObject) {
		Smooks smooks = null;
		StringWriter writer = null;
		try {

			smooks = new Smooks("smooks-config.xml");
			ExecutionContext executionContext = smooks.createExecutionContext();
			writer = new StringWriter();
			smooks.filterSource(executionContext, new JavaSource(
					inputJavaObject), new StreamResult(new FileOutputStream(
					new File("output.xml"))));

		} catch (IOException e) {

			LOGGER.error(e.getMessage());
		} catch (SAXException e) {

			LOGGER.error(e.getMessage());
		} finally {
			smooks.close();
		}

		return writer.toString();
	}

	public static void main(String[] args) {
		SmooksTransform transform = new SmooksTransform();
		Order javaInput = new Order();
		String transResult;

		LOGGER.debug(javaInput);

		transResult = transform.runSmooksTransform(javaInput);
		LOGGER.debug(transResult);
		LOGGER.debug("\n\n");
	}
}
