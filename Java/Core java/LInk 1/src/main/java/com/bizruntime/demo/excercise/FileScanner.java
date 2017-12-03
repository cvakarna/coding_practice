package com.bizruntime.demo.excercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScanner {
public static void main(String[] args) throws FileNotFoundException {

	int num1;
	float num2;
	String name;
	
	Scanner sc = new Scanner(new File("test.txt"));
	num1=sc.nextInt();
	num2=sc.nextFloat();
	name=sc.next();
	
	System.out.println("Hi ! "+name+" , the sum of "+num1+" and "+num2+ " is "+(num1+num2));
	
	
}
}
