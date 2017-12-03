package com.bizruntime.demo.excercise;

import java.util.Scanner;

public class KeyBoardScanner {
public static void main(String[] args) {
	
	int num1;
	float num2;
	String name;
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter  an integer : ");
	num1=sc.nextInt();
	System.out.print("Enter an Floating point number : ");
	num2=sc.nextFloat();
	System.out.print("Enter an name : ");
	name=sc.nextLine();
	
	System.out.println("Hi !"+name+" , the sum of "+num1+" and "+num2+ " is "+(num1+num2));
	
	
}
}
