package com.bizruntime.socket;

import java.nio.charset.StandardCharsets;

public class App 
{
    public static void main( String[] args )
    {
    	char c=255;
    	String s=c+"";
    	System.out.println(c);
    	byte []b=s.getBytes(StandardCharsets.US_ASCII);
    	for (int i = 0; i < b.length; i++)
    	System.out.println(b[i]);
    }
}
