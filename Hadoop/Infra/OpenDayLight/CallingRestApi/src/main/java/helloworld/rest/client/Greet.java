package helloworld.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

public class Greet {
	private final Logger log = Logger.getLogger(Greet.class);
	String baseURL = "http://localhost:8181/restconf/operations/helloworld:hello-world";
	String user = "admin";
	String password = "admin";
	String greetTo ;
	
	
	public Greet(String greetTo) {
		this.greetTo = greetTo;
	}

	void invokeURL(){
		ObjectMapper objToJsonString = new ObjectMapper();
		try {
			
			URL url = new URL(baseURL);
			
			String auth = user + ":" + password;
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			byte[] authEncBytes = Base64.encodeBase64(auth.getBytes());
			String authStringEnc = new String(authEncBytes);
			connection.setRequestProperty("Authorization", "Basic "+authStringEnc);
            connection.setRequestProperty("Content-Type", "application/json"); 
			connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            OutputStreamWriter output = new OutputStreamWriter(connection.getOutputStream());
            Input inp = new Input();
            inp.setName(greetTo);

            output.write("{\"input\": "+ objToJsonString.writeValueAsString(inp)+"}");
            output.flush();
            
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
		String greetTo = "JothiPandiyan";
		Greet odl = new Greet(greetTo);
		odl.invokeURL();
	}
	
}
