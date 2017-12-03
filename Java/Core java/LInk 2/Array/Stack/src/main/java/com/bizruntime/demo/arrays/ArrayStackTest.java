package com.bizruntime.demo.arrays;

import org.apache.log4j.Logger;

public class ArrayStackTest {

	static final Logger log=Logger.getLogger(ArrayStackObject.class);
	public static void main(String[] args) {
		
	valueInsertInArray();
		
	
		
	}
	

	public static void  valueInsertInArray(){
		int size0fArray=10;
		ArrayStackObject stack=new ArrayStackObject(size0fArray);
		Integer num=0;

		log.info("Size of an StackArray "+size0fArray);
		log.info("----------------------------------");
		try{
			stack.pop();
		}catch(NullPointerException ne){
			log.error("Stack is empty ");
		}catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < size0fArray; i++) {
			num=(int) (Math.random()*100);
			stack.push(num);
			log.info("inserted : "+num);
		}
		stack.push(10);
		
		log.info("----------------------------------");
		
		for (int i = 0; i < size0fArray; i++) {
			
			log.info("remove "+stack.pop());
		}
		
		
		log.info("\nInserting and Deleting of Stack done");

	}

}
