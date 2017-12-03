package com.bizruntime;

import org.apache.log4j.Logger;

public class AsArguments {
	private static Logger log=Logger.getLogger(AsArguments.class);

	public static void main(String[] args) {
		AsArguments example=new AsArguments();
		example.add((num1,num2)->num1+num2);
	}
	
	void add(Adder add){
		int a=10;
		int b=10;
		log.debug("Result "+add.add(a, b));
	}
}
