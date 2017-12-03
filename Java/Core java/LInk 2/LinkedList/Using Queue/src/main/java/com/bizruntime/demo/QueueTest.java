package com.bizruntime.demo;

import org.apache.log4j.Logger;


public class QueueTest {
	static Queue queue=new Queue();
	static Integer num = null;
	static  final  Logger log=Logger.getLogger(QueueTest.class);

	
	public static void main(String[] args) {

		insert(5);
		remove();
	}

	
	public static void insert(int max) {
		for (int i = 0; i < max; i++) {
			num=(int) (Math.random()*100);
			queue.push(num);
			log.info("insert : "+num);
		}
	}

		
	

	private static void remove() {
		while(!queue.isEmpty())
			log.info("deleted : "+queue.pop());
		}
	}

	


