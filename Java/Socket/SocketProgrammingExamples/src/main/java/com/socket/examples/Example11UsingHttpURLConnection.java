package com.socket.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.sun.org.apache.xml.internal.utils.URI;

public class Example11UsingHttpURLConnection {
	public static Logger log = Logger.getLogger(Example11UsingHttpURLConnection.class);
	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws IOException, URISyntaxException {

		Example11UsingHttpURLConnection ex = new Example11UsingHttpURLConnection();
		ex.createSocketObject();
	}

	private void createSocketObject() throws IOException, URISyntaxException {	
		URL	 url = new URL("http://www.google.com/search?q=bizruntime");

		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();

		log.debug("\nSending 'GET' request to URL : " + url);
		log.debug("Response Code : " + responseCode);
		log.debug("Response Message "+con.getResponseMessage());
		log.debug("get permission "+con.getPermission());
		log.debug("header field "+con.getHeaderField(0));
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		log.debug(response.toString());
		
		
		URL	 url1 = new URL("http://www.google.com/search");

		java.net.URI uri=url1.toURI();
		
		System.out.println(uri);
	}
	
	
	
}
