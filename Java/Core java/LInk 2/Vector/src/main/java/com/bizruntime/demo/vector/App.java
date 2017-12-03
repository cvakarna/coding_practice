package com.bizruntime.demo.vector;

import java.util.Enumeration;
import java.util.Vector;

import org.apache.log4j.Logger;


public class App 
{
	
	static  final  Logger log=Logger.getLogger(App.class);
    public static void main( String[] args )
    {
    	addElement();
    }
    
    public static void addElement(){
    	Vector v=new Vector(15);
    	Integer num;
    	log.info("started to add elements in vector ");
    	
    	for (int i = 0; i < 10; i++) {
			num=(int) (Math.random()*100);
			v.addElement(num);
			log.info("inserted "+num);
		}
    	
    	log.info("size of vector after 10 elements added : "+v.size());
    	log.info("capacity of vector after 10 elements added : "+v.capacity());
    	
    	Enumeration e=v.elements();
    	while(e.hasMoreElements()){
    		log.info("elemets : "+e.nextElement());
    	}
    	log.info("End of class..");
    }
    
}
