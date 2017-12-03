package com.bizruntime.demo;

import org.apache.log4j.Logger;


public class LInkedListTest {
	static LinkedList ll = new LinkedList();
	static Integer num = null;

	static  final  Logger log=Logger.getLogger(LInkedListTest.class);

	
	public static void main(String[] args) {

		insert(5);
		insertEnd(5);
		peek(10);
		remove(5);
		removEnd();
		
	}

	
	public static void insert(int max) {
		for (int i = 0; i < max; i++) {
			num=(int) (Math.random()*100);
			ll.insert(num);
			log.info("insert : "+num);
		}
	}

	private static void insertEnd(int max) {
		for (int i = 0; i < max; i++) {
			num=(int) (Math.random()*100);
			ll.insertEnd(num);
			log.info("insert in end : "+num);
		}
	}

	
	private static void peek(int num) {
		for (int i = 0; i < num; i++) 
		log.info("peek : "+ll.peek(i));
	}

	private static void remove(int max) {
		for (int i = 0; i < max; i++) {
			log.info("deleted : "+ll.remove());
		}
	}

	private static void removEnd() {
		while(ll.isEmpty())
			log.info("deleted from end: "+ll.removeEnd());
	}
	
	}


