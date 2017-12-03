package com.bizruntime.demo.arrays;

import org.apache.log4j.Logger;

public class ArrayStackObject {
	
	protected Object head[];
	protected int pointer;

	static final Logger log=Logger.getLogger(ArrayStackObject.class);
	
	public ArrayStackObject(int capacity) {
		head=new Object[capacity];
		pointer=-1;
	}
	
	public boolean isEmpty(){
		return pointer == -1;
	}
	
	public void push(Object obj){
		if(pointer+1<head.length)
			head[++pointer]=obj;
		else
			log.error("Array size if full....");
	}
	
	public  Object  pop(){
		if(isEmpty()){
			throw new NullPointerException();
		}
				return head[pointer--];
	}
	
	
}
