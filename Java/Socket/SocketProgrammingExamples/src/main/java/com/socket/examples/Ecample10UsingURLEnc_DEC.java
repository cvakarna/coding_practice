package com.socket.examples;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

public class Ecample10UsingURLEnc_DEC {
	public static Logger log = Logger.getLogger(Ecample10UsingURLEnc_DEC.class);

	public static void main(String[] args) throws IOException {

		Ecample10UsingURLEnc_DEC ex = new Ecample10UsingURLEnc_DEC();
		ex.createSocketObject();
	}

	private void createSocketObject() throws IOException {	
		
		String url="www.google.com";
		String uriToEncode="/test/p@th";
		String encodedUrl=url+URLEncoder.encode(uriToEncode,"UTF-8");
		log.debug("Encode url -> "+encodedUrl);
		
		String decodedUrl=URLDecoder.decode(encodedUrl,"UTF-8");
		log.debug("decode url -> "+decodedUrl);
		
		
	}
}
