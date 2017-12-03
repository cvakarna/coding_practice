package samza.yahoo.finance.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.samza.config.Config;
import org.apache.samza.metrics.MetricsRegistry;
import org.apache.samza.system.IncomingMessageEnvelope;
import org.apache.samza.system.SystemStreamPartition;
import org.apache.samza.util.BlockingEnvelopeMap;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import samza.yahoo.finance.pojo.Resources;

public class YahooFinanceConsumer extends BlockingEnvelopeMap implements
		Runnable {
	private Logger log = LoggerFactory.getLogger(YahooFinanceConsumer.class);

	private String systemName;

	private SystemStreamPartition systemStreamPartition;

	private String BASEURL="http://finance.yahoo.com";
	private String QUERY= "/webservice/v1/symbols/";
	private String companies;
	private String FORMAT="/quote?format=json&view=detail";
	
	
	public YahooFinanceConsumer() {

	}

	public YahooFinanceConsumer(String systemName, Config config,
			MetricsRegistry registry) {
		this.systemName = systemName;	
		this.companies=config.get("systems."+systemName+".companies");
	}

	public void run() {
		try {
			
			// Collecting url
			String fullUrlStr = this.BASEURL + this.QUERY+this.companies+this.FORMAT;
			ObjectMapper mapper=new ObjectMapper();
			URL url = new URL(fullUrlStr);
			
			BufferedReader reader=null;
			log.debug("-->"+fullUrlStr);
			while (true) {
				try {
					reader = new BufferedReader(new InputStreamReader(url.openStream()));
					String json = null;
					String jsonString="";
					while ((json = reader.readLine()) != null)
						jsonString += json;
					
					jsonString = jsonString.substring(jsonString.indexOf("["), jsonString.indexOf("]")+1);
					
					
					
					put(systemStreamPartition,new IncomingMessageEnvelope(systemStreamPartition,null, null,	jsonString));			 

					Thread.sleep(2000);

				} catch (InterruptedException  | SocketException e) {
					log.error("Exception Occured "+e.getMessage());	
				}catch ( IOException  e) {
					log.error("Exception Occured "+e.getMessage());	
				}
			}
		} catch (MalformedURLException e) {
			log.error("Exception Occured "+"Mention a valid URL..."+e.getMessage());	
			throw new RuntimeException();
		}
	}

	public void start() {
		new Thread(this).start();
	}

	public void stop() {
		log.debug("YahooFinanceConsumer stopped... ");
	}

	public void register(SystemStreamPartition systemStreamPartition,
			String offset) {
		this.systemStreamPartition = systemStreamPartition;
		super.register(systemStreamPartition, offset);
	}
}
