package com.bizruntime.datastructure;

import java.util.Vector;

public class PriorityVector extends Vector {

	public void addElement(Comparable o){
		int i,j ;
		int k=0;
		for ( i=0 ,j=size(); i< j &&(k=((Comparable)(elementAt(i))).compareTo(o))<0; i++);
		System.out.println(k);
			insertElementAt(o, i);
		
	}
}
