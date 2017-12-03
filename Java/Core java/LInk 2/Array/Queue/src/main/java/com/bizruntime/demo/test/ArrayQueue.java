package com.bizruntime.demo.test;

import com.bizruntime.custom.exception.EmptyQueueException;

public class ArrayQueue {

	protected Object array[];
	protected int start,end;
	protected boolean full;
	
	public ArrayQueue(int capacity) {
		array=new Object[capacity];
		start=end=0;
		full=false;
	}
	
	public boolean isEmpty()
	{
		return ((start==end) && !full);
	}
	
	public void insert(Object obj ){
		if(!full){
			array[start = (++start % array.length)]=obj;
		}if(start== end)
			full=true;
	
	}

	public Object remove( ) {
		if(full)
			full=false;
		else if(isEmpty()){
			throw new EmptyQueueException();
		}
			return array[end= (++end%array.length)];
	}
	
	
	
	
}
 