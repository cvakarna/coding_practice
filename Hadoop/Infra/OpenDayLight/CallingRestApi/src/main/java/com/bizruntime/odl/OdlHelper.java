package com.bizruntime.odl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

public class OdlHelper {
	private final Logger log = Logger.getLogger(OdlHelper.class);
	String baseURL = "http://192.168.1.130:8181/ /operational/opendaylight-inventory:nodes/node/openflow:1/node-connector/openflow:1:1";
	String auth = "admin:admin";
	void invokeURL(){
		
		try {
			
			URL url = new URL(baseURL);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			byte[] authEncBytes = Base64.encodeBase64(auth.getBytes());
			String authStringEnc = new String(authEncBytes);
			connection.setRequestProperty("Authorization", "Basic "+authStringEnc);
            connection.setRequestProperty("Content-Type", "application/json"); 
			connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            InputStream is = (InputStream) connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            StringBuffer result = new StringBuffer();
            String line = "";
           
            while((line = in.readLine())!=null)
            	result.append(line);
        	
            log.info(result);
		} catch (MalformedURLException e) {
			log.error("URL is not well formed : "+e.getMessage());
		}catch (IOException e){
			log.error("Given URL not found or Unauthorized : "+e.getMessage());
			e.printStackTrace();
		}catch (IllegalArgumentException e){
			log.error("Enter the host url : "+e.getMessage());					
		}
		
		
	}
	
	public static void main(String[] args) {
		OdlHelper odl = new OdlHelper();
		odl.invokeURL();
	}
	
}
