package com.bizruntime.demo.test;

import org.apache.log4j.Logger;

import com.bizruntime.custom.exception.EmptyQueueException;

public class ArrayQueueTest {

	static final Logger log=Logger.getLogger(ArrayQueue.class);
	public static void main(String[] args) {
	valueInsertInArray();
	}
	

	public static void  valueInsertInArray(){
		int size0fArray=10;
		ArrayQueue queue=new ArrayQueue(size0fArray);
		Integer num=0;
		log.info("Size of an StackArray "+size0fArray);
		log.info("----------------------------------");
		try{
			queue.remove();
		}catch(EmptyQueueException ee){
			log.error("Queue is empty cant do remove operation");
		}catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 1; i <= size0fArray; i++) {
			num=(int) (Math.random()*100);
			queue.insert(num);
			log.info("inserted : "+num);
		}
		
		log.info("----------------------------------");
		
		for (int i = 0; i < size0fArray; i++) {
			log.info("remove : "+queue.remove());
		}
		
		
		log.info("\nInserting and Deleting of Queue done");

	}

}
