package com.bizruntime.demo.excercise.number.series;

public class GCD {
public static void main(String[] args) {
	
	gcd(10,5);
	
}
static void gcd(int num1,int num2){
	
	int temp=num2;
	int temp2=0;
	
	while(num2>0){
	
		temp2=num2;
		num2=num1%num2;
		num1=temp2;
	}
	System.out.println(num1);
}
}
