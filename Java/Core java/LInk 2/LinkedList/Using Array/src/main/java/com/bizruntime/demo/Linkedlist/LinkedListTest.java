package com.bizruntime.demo.Linkedlist;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class LinkedListTest {

	static final Logger log=Logger.getLogger(LinkedListTest.class);
	public static void main(String[] args) {
	
	valueInsertInArray();
	}
	

	public static void  valueInsertInArray(){
		       UsingArray l = new UsingArray(10);
		        Integer num = null;
		        log.info(" Inserting from starting ");
		        for(int i=0;i<5;i++){
		            num = (int)(Math.random() * 100);
		            l.insert(num);
		            log.info("Insert : " +num);
		        }
		        while(!l.isFull()){
		            num = (int)(Math.random() * 100);
		            l.insertEnd(num);
		            log.info("Insert from : " +num); }

		        for(int i=0;i<l.size();i++)
		        	log.info("peek : "+l.peek(i));

		        for(int i	=0;i<5;i++)
		        	log.info("Delete : "+l.remove());
		        
		        while(!l.isEmpty())
		        	log.info("Delete from end : "+l.removeFromEnd());
		    }

	}


