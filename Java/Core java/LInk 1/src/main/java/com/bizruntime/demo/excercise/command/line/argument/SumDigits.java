package com.bizruntime.demo.excercise.command.line.argument;

public class SumDigits {
public static void main(String[] args) {
	int add=0;
	for (int i = 0; i < args[0].length(); i++) {
		
	 add+=(args[0].charAt(i)-'0');
	 System.out.println(args[0].charAt(i));
	}
	System.out.println("Sum of digits "+args[0] +" is "+add);
}
}
