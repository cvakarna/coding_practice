package odl.vtn.rest;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class VTNMainClass {

	private final Logger log = Logger.getLogger(VTNMainClass.class);
	private Scanner sc = new Scanner(System.in);

	private VTNCoordinator co = new VTNCoordinator();

	public void validate() {

	}

	public void createVtns() {
		String requestURI = "/controllers.json";

		log.debug("Enter no of controllers to create");
		
		int num = 0, num1 = sc.nextInt();
		String controller_id=null;
		while (num++ < num1) {
			log.debug("Enter Controller Name");
			controller_id = sc.next();
			log.debug("Enter Ipaddress of controller");
			String ipaddr = sc.next();
			co.createController(controller_id, ipaddr, requestURI);
		}
		
		requestURI = "/vtns.json";
		log.debug("Enter VTN Name");
		String vtnName = sc.next();
		co.createVTN(requestURI, vtnName);

		log.debug("Enter No of bridges to create");
		int noOfBridges = sc.nextInt();

		for (int i = 0; i < noOfBridges; i++) {

			log.debug("Enter bridges Name");

			String br_name = sc.next();
			requestURI = "/vtns/" + vtnName;
			log.debug("Enter controller for " + br_name);
			controller_id = sc.next();
			co.createBridge(controller_id, br_name, requestURI
					+ "/vbridges.json");

			log.debug("Enter No of interfaces to create");
			int noOfInterface = sc.nextInt();

			requestURI += "/vbridges/" + br_name;
			for (int j = 0; j < noOfInterface; j++) {

				log.debug("Enter interface Name");
				String if_name = sc.next();
				co.createInterface(requestURI + "/interfaces.json", if_name);
				while (i++ < 2) {
					log.debug("Enter portId to create.\nFormat must match like this PP-OF:openflow:1-s1-eth1");
					String logical_port = sc.next();
					co.createPortMapping(requestURI + "/interfaces/" + if_name
							+ "/portmap.json", logical_port);
				}

			}
			log.debug("Enter router Name");
			
		}
	}

	public static void main(String[] args) {
		VTNMainClass main = new VTNMainClass();
		main.createVtns();
	}

}
