package odl.vtn.rest;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class VTNCoordinator {
	private final Logger log = Logger.getLogger(VTNCoordinator.class);
	
	VtnRest restIMpl = new VtnRestImpl();
	LinkedHashMap<String, String> lm =new LinkedHashMap<String, String>();	
	Map<String, LinkedHashMap<String, String>> m= new LinkedHashMap<String, LinkedHashMap<String, String>>();
	ObjectMapper objToJsonString = new ObjectMapper();
	
	public void createRouter(String requestURI, String router_name) {		
		
		lm.put("vrt_name", router_name);
		lm.put("controller_id", "odc1");
		lm.put("domain_id", "(DEFAULT)");

		m.put("vrouter", lm);
		String requestBody = objToJsonString(m);
		restIMpl.post(requestBody, requestURI);
	}
	
	public void createPortMapping(String requestURI, String logical_port) {

		lm.put("logical_port_id", logical_port);
		m.put("portmap", lm);
		String requestBody = objToJsonString(m);
		log.debug(requestBody);
		restIMpl.put(requestBody, requestURI);
		restIMpl.get(requestURI);
	}

	public void createInterface(String requestURI, String if_name) {
		
		lm.put("if_name", if_name);
		m.put("interface", lm);
		String requestBody = objToJsonString(m);
		restIMpl.post(requestBody, requestURI);
		restIMpl.get(requestURI);

	}

	public void createBridge(String controller_id, String br_name, String requestURI){
		
		lm.put("vbr_name", br_name);
		lm.put("controller_id", controller_id);
		lm.put("domain_id", "(DEFAULT)");

		m.put("vbridge", lm);

		String createVbridge = objToJsonString(m);
		restIMpl.post(createVbridge, requestURI);
		restIMpl.get(requestURI);
		
	}



	public void createVTN(String requestURI, String vtnName) {
		
		lm.put("vtn_name", vtnName);
		m.put("vtn", lm);
		String createVtn = objToJsonString(m);
		restIMpl.post(createVtn, "/vtns.json");
		restIMpl.get(requestURI);

	}

	public void createController(String controller_id, String ipaddr, String requestURI1)  {

		lm.put("controller_id", controller_id);
		lm.put("ipaddr", ipaddr);
		lm.put("type", "odc");
		lm.put("version", "1.0");
		lm.put("auditstatus", "enable");
		
		m.put("controller", lm);
		
		String createVtn = objToJsonString(m);
		System.out.println(createVtn);
		restIMpl.get(requestURI1);
		restIMpl.post(createVtn, requestURI1);
		restIMpl.get(requestURI1);
	}
	
	public String objToJsonString(Map<String, LinkedHashMap<String, String>> obj){
		String toJson = null;
		try {
			 toJson = objToJsonString.writeValueAsString(m);
		} catch (JsonGenerationException e) {
		} catch (JsonMappingException e) {
		} catch (IOException e) {
		}
		
		lm.clear();
		m.clear();
		System.out.println("json"+toJson);
		return toJson;
	}


}
