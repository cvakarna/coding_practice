package odl.vtn.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

public class VtnRestImpl implements VtnRest {
	private final Logger log = Logger.getLogger(VtnRestImpl.class);
	private final String BASE_URL = "http://192.168.1.129:8083/vtn-webapi";
	private final String USER = "admin";
	private final String PASSWORD = "adminpass";
	private final String content_Type = "application/json";

	private HttpURLConnection getHttpUrlconnection(String requestResource,String requestMethod) {
		URL ur1;
		HttpURLConnection connection = null;
		try {
			System.out.println(BASE_URL + requestResource);
			ur1 = new URL(BASE_URL + requestResource);
			connection = (HttpURLConnection) ur1.openConnection();

			connection.setRequestMethod(requestMethod);
			String auth = this.USER + ":" + this.PASSWORD;
			byte[] authEncBytes = Base64.encodeBase64(auth.getBytes());
			String authStringEnc = new String(authEncBytes);

			connection.setRequestProperty("Authorization", "Basic "
					+ authStringEnc);
			connection.setRequestProperty("content-Type", content_Type);
			connection.setRequestProperty("accept", content_Type);

		} catch (MalformedURLException e) {
			log.error("URL is not well formed. verify the protocol : "
					+ e.getMessage());

		} catch (IOException e) {
			log.error("Given URL not found or Unauthorized or requestPropert not matching: "
					+ e.getMessage());
		} catch (IllegalArgumentException e) {
			log.error("Enter the host url : " + e.getMessage());
		}
		return connection;
	}

	void getInputStream(InputStream input) {
		StringBuffer jsonOutput = new StringBuffer();
		String line = "";
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(input));
			while ((line = in.readLine()) != null)
				jsonOutput.append(line);
			log.info(jsonOutput);
		} catch (IOException e) {
			log.error("Error on getting inputstream or reading inputStream "
					+ e.getMessage());
		}
	}

	public void get(String requestResource) {
		StringBuffer jsonOutput = new StringBuffer();
		String line = "";
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					getHttpUrlconnection(requestResource, "GET")
							.getInputStream()));
			while ((line = in.readLine()) != null)
				jsonOutput.append(line);
			log.info(jsonOutput);
		} catch (IOException e) {
			log.error("Error on getting inputstream or reading inputStream "
					+ e.getMessage());
		}
	}

	public void post(String requestBody, String requestResource) {
		try {
			HttpURLConnection connection = getHttpUrlconnection(requestResource, "POST");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			OutputStream op = connection.getOutputStream();

			op.write(requestBody.getBytes());
			op.flush();
			
			connection.getInputStream(); // getting input Stream
	
		} catch (IOException e) {
			log.error("Error on getting outputstream or while flushing"
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	public void put(String requestBody, String requestResource) {

		try {
			HttpURLConnection connection = getHttpUrlconnection(requestResource, "PUT");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			OutputStream op = connection.getOutputStream();
			op.write(requestBody.getBytes());
			op.flush();

			connection.getInputStream(); // getting input Stream
	
		} catch (IOException e) {
			log.error("Error on getting outputstream or while flushing"
					+ e.getMessage());
			e.printStackTrace();
		}
	}

		public void delete(String URI){
			try {
				HttpURLConnection connection = getHttpUrlconnection(URI, "DELETE");
				connection.setUseCaches(false);
				connection.setDoInput(true);
				connection.setDoOutput(true);
				connection.getInputStream(); // getting input Stream
		
			} catch (IOException e) {
				log.error("Error on getting outputstream or while flushing"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
}
