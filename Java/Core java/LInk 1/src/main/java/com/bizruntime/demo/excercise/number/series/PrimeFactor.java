package com.bizruntime.demo.excercise.number.series;

import java.util.Scanner;

import com.sun.org.apache.regexp.internal.recompile;

public class PrimeFactor {
	static int upperBound;
	 static int sum;
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter upper bound : ");
	upperBound =  sc.nextInt();
	isProductOfPrimeFactors(upperBound);
}

static void isProductOfPrimeFactors(int 	posInt){
	boolean temp;
	System.out.println("These numbers are equal to the product of prime factors:  ");
	for (int i = 0; i <= posInt; i++) {
		
		temp=isPrime(1);
		if(temp==true)
			System.out.print(temp+" ");
	}
	}

static boolean isPrime(int num){
	
	boolean val=true;
	int rootValue=(int) Math.sqrt(num);
	
	if(num==2)
		return true;
	if(num%2==0)
		return false;
	
	for (int i = 3; i <= Math.round(Math.sqrt(num)); i+=2) {
		if(num%i==0)
			return false;
	}
	return val;
}
}