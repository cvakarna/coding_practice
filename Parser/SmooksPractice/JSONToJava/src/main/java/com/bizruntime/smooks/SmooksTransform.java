/*
	Milyn - Copyright (C) 2006 - 2010

	This library is free software; you can redistribute it and/or
	modify it under the terms of the GNU Lesser General Public
	License (version 2.1) as published by the Free Software
	Foundation.

	This library is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

	See the GNU Lesser General Public License for more details:
	http://www.gnu.org/licenses/lgpl.txt
*/
package com.bizruntime.smooks;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.milyn.Smooks;
import org.milyn.SmooksException;
import org.milyn.container.ExecutionContext;
import org.milyn.event.report.HtmlReportGenerator;
import org.milyn.io.StreamUtils;
import org.milyn.payload.StringResult;
import org.milyn.xml.XmlUtil;
import org.xml.sax.SAXException;

public class SmooksTransform {
	private static Logger LOGGER = Logger.getLogger(SmooksTransform.class);

    private static byte[] messageIn = readInputMessage();

    private final Smooks smooks;

    protected SmooksTransform() throws IOException, SAXException {
        smooks = new Smooks("smooks-config.xml");
    }

    protected String runSmooksTransform(ExecutionContext executionContext) throws IOException, SAXException, SmooksException {
        try {
            Locale defaultLocale = Locale.getDefault();
            Locale.setDefault(new Locale("en", "IE"));

            StringResult result = new StringResult();
           smooks.filterSource(executionContext, new StreamSource(new ByteArrayInputStream(messageIn)), result);

            Locale.setDefault(defaultLocale);

            return result.toString();
        } finally {
            smooks.close();
        }
    }

    public static void main(String[] args) throws IOException, SAXException, SmooksException {
 
        SmooksTransform smooksMain = new SmooksTransform();
        ExecutionContext executionContext = smooksMain.smooks.createExecutionContext();
         LOGGER.debug(smooksMain.runSmooksTransform(executionContext));
        LOGGER.debug(executionContext.getBeanContext().getBean("order"));
        
    }

    private static byte[] readInputMessage() {
        try {
            return StreamUtils.readStream(new FileInputStream("src/main/resources/input.jsn"));
        } catch (IOException e) {
            e.printStackTrace();
            return "<no-message/>".getBytes();
        }
    }


  
}
