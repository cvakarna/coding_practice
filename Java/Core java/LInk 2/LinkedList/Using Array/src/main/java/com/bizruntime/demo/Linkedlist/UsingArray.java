package com.bizruntime.demo.Linkedlist;

import org.apache.log4j.Logger;

public class UsingArray {
	
	protected Object array[];
	protected int start,end,number;

	static final Logger log=Logger.getLogger(UsingArray.class);
	
	public UsingArray(int capacity) {
		array=new Object[capacity];
		number=start=end=0;
	}
	public boolean isEmpty(){
		return number == 0;
	}
	
	public int size(){
		return number;
	}
	
	public boolean isFull(){
		return number>=array.length;
	}
	public void insert(Object o){
        if(number < array.length){
            array[start = (++start % array.length)] = o;
            number++;
        }
    }
    public void insertEnd(Object o){
        if(number < array.length){
            array[end] = o;
            end = (--end + array.length) % array.length;
            number++;
        }
    
    }
    public Object peek(int num){
        if(num >= number)
            return null;
        return array[(end + 1 + num) % array.length];
    }
    public Object remove(){
        if(isEmpty())
            return null;
        number--;
        int i = start;
        start = (--start + array.length) % array.length;
        return array[i];
    }
    public Object removeFromEnd(){
        if(isEmpty())
            return null;
        number--;
        return array[end = (++end % array.length)];
    }
	
}
