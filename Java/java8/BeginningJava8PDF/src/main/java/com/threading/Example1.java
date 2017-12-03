package com.threading;

import org.apache.log4j.Logger;

public class Example1  implements Runnable{

	static Logger log = Logger.getLogger(Example1.class);

	public static void main(String[] args) {
		Example1 example=new Example1();
		example.demo();
	}

	private void demo() {
		
		Example1 example=new Example1();
		Thread th=new Thread(example);
		th.start();

		Runnable runnable= ()-> log.debug("run method called using lamda expression ");
		Thread th1=new Thread(runnable);
		th1.start();
		
		Thread th2=new  Thread(Example1 :: exceute);
		th2.start();
	
		String name="sample";
		//Thread th2=new  Thread(String :: "t".length());
		
	}
	
	@Override
	public void run() {
		log.debug("run() method called ");
	}
	
	
	public static void exceute(){
		log.debug("execute() method called ");
	}
}
