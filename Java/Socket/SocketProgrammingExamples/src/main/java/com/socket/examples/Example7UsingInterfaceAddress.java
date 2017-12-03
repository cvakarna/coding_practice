package com.socket.examples;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import org.apache.log4j.Logger;

public class Example7UsingInterfaceAddress {
	public static Logger log = Logger
			.getLogger(Example7UsingInterfaceAddress.class);

	public static void main(String[] args) throws SocketException {
		Example7UsingInterfaceAddress ex = new Example7UsingInterfaceAddress();
		ex.createSocketObject();
		    Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();       
	
		    // Network Interface
		    for (NetworkInterface netint : Collections.list(nets)){
	            displayInterfaceInformation(netint);
	            
	        //Interface Address 
	           List<InterfaceAddress> in= netint.getInterfaceAddresses();
	           for(InterfaceAddress i:in){
	        	  System.err.println("Address -> " +i.getAddress()); 
	        	  System.err.println("Broadcast-> " +i.getBroadcast()); 
	        	  System.err.println("NetworkPrefixLength -> " +i.getNetworkPrefixLength()); 
	           }
	        }
	  	}

	static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        log.debug("Display name: "+ netint.getDisplayName());
        log.debug("Name: "+ netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
        	log.debug("InetAddress: "+ inetAddress);	
        }
        log.debug("\n");
     }

	private void createSocketObject() {
		
	}

}
