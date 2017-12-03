package com.bizruntime.datastructure;

public class CustomInteger implements CustomComparable {

	int i;

	public CustomInteger() {

	}

	public CustomInteger(int j) {
		set(j);
	
	

	}
	public int get() {
		return i;	
	}

	public void set(int j) {
		this.i = j;
	}

	
	@Override
	public String toString() {
		return ""+get();
	}
	
	public int compareTo(Object o) {
		
		if(o instanceof CustomInteger)
			if(get() > ((CustomInteger)o).get())
				return 1;
			else if(get() < ((CustomInteger)o).get())
				return -1;
		
		return 0;
	}
}
