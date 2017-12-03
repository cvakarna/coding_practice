package com.bizruntime.process;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Add2Numbers {
	private Logger log = Logger.getLogger(Add2Numbers.class);
	public static void main(String[] args) {
		
	    Add2Numbers a=new Add2Numbers();
	    a.add();
	   }
	void add(){
		  Scanner in = new Scanner(System.in);
	      int num1 = in.nextInt();
	      int num2 = in.nextInt();
	      System.out.println("Printing this from Another class"+100 );
	}
}
