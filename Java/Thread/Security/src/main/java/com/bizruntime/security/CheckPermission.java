package com.bizruntime.security;

import java.io.FilePermission;
import java.io.IOException;
import java.security.Permission;

import org.apache.log4j.Logger;

public class CheckPermission extends SecurityManager {
	private Logger log = Logger.getLogger(CheckPermission.class);

	public static void main(String[] args) throws IOException {
		CheckPermission example = new CheckPermission();
		example.createProcess();
	}

	private void createProcess() throws IOException {
		System.setProperty("java.security.policy","src/main/resources/java.policy");
		FilePermission p = new FilePermission("src/main/resources/*","read,write");

		SecurityManager sc = new SecurityManager();
		System.setSecurityManager(sc);
		
		//AddingFile
		checkPermission(p);
		log.debug("FilePermission  granted..");

		//socket connection
		sc.checkConnect("www.google.com", 80);
		log.debug("SocketPermission  granted..");

		//Property
	
		
	}
	
	@Override
	public void checkPermission(Permission perm) {
		super.checkPermission(perm);
	}
}
