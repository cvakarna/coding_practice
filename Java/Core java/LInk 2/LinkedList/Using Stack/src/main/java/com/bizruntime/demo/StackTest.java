package com.bizruntime.demo;

import org.apache.log4j.Logger;


public class StackTest {
	static Stack s=new Stack();
	static Integer num = null;
	static  final  Logger log=Logger.getLogger(StackTest.class);

	
	public static void main(String[] args) {

		insert(5);
		remove(5);
	}

	
	public static void insert(int max) {
		for (int i = 0; i < max; i++) {
			num=(int) (Math.random()*100);
			s.push(num);
			log.info("insert : "+num);
		}
	}

		
	

	private static void remove(int max) {
		for (int i = 0; i < max; i++) {
			log.info("deleted : "+s.pop());
		}
	}

		}


