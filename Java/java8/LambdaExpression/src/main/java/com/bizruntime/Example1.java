package com.bizruntime;

import org.apache.log4j.Logger;

public class Example1 {
	private static Logger log=Logger.getLogger(Example1.class);
	public static void main(String[] args) {
		Example1 example=new Example1();
		example.lamdaExpressions(10);
		example.sum(10,20);
		example.join("Biz","runtime");		
	}

	
	private void join(String str1, String str2) {
		Joinner join= ( s1, s2) -> s1+s2;
		log.debug(join.join(str1, str2));
	}


	private void sum(int i, int j) {
		Adder add= (int a,int b)-> { return a+b; }  ;
		log.debug("Adding using Lamda Expression -> "+add.add(i, j));
	}

	private void lamdaExpressions(int i) {
		
		Increment increment=new Increment() {
			
			@Override
			public int increment(int a) {
				return a+1;
			}

		};	
		log.debug("Using anonymous class ->  "+increment.increment(1));
		
		Increment in = a -> i+1;
		
		log.debug("Using Lamda Expression -> "+in.increment(1));
	
	}
	
}

@FunctionalInterface
interface Increment{
	int increment(int a);
}

@FunctionalInterface
interface Adder{
	 int add(int a,int b);
}

@FunctionalInterface
interface Joinner{
	String join(String str1,String str2);
	@Override
	public String toString();
}