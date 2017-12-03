package com.bizruntime.datastructure;

import java.util.Enumeration;

import org.apache.log4j.Logger;

public class PriorityVectorTest {
	
	
	static final Logger log=Logger.getLogger(PriorityVectorTest.class);
public static void main(String[] args) {
	
	PriorityVector v=new PriorityVector();
	log.debug("started adding...... ");
	Integer num;
	for (int i = 0; i < 10; i++) {
		num= (int) (Math.random()*100);
		v.addElement(num);
		log.debug("add : "+num);
	}
	
	log.debug("Printing...... ");
	
	Enumeration e=v.elements();
	while(e.hasMoreElements())
		log.info(e.nextElement());

	log.debug("sorting over vector finished  ");

}
}
