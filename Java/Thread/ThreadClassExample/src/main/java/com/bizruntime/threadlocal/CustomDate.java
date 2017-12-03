package com.bizruntime.threadlocal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class CustomDate  implements Runnable{
	private  Logger log = Logger.getLogger(CustomDate.class);
	
	private ThreadLocal<DateFormat> df=new ThreadLocal<DateFormat>(){
		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat("dd/mm/yyyy");
		}
	};
	
	public static void main(String[] args) {
		CustomDate method=new CustomDate();
		method.threadCreation();
		
	}

	private void threadCreation() {
		Thread th1=new Thread(new CustomDate());
		Thread th2=new Thread(new CustomDate());
		th1.start();
		th2.start();
		log.debug("main thread finished executing.. ");
	}
	
	@Override
	public void run() {
		log.info("getFormatCurrentDate() for thread "+Thread.currentThread().getName()+" is "+formatCurrentDate());
		log.info("formatFirstOfJanyary1970() for thread "+Thread.currentThread().getName()+" is "+formatFirstOfJanyary1970());

	}
	
	public String formatCurrentDate(){
		
		return df.get().format(new Date());
	}
	public String formatFirstOfJanyary1970() {
		return df.get().format(new Date(0));

	}
}
