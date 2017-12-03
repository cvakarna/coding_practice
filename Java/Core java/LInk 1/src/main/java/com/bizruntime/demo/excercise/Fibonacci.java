package com.bizruntime.demo.excercise;

public class Fibonacci {
public static void main(String[] args) {
	
	findFibbonacci(20);
}

static void findFibbonacci(int max){
	
	int n=3;
	int fnMinus1=1;
	int fnMinus2=1;
	int sum;
	
	sum=fnMinus1+fnMinus2;
	int fn=sum;
	System.out.println("First "+max+" fibbonacci series are ");
	int count=0;
	while(n<=max){

		
		if(fnMinus1==1 && 	fnMinus2==1)
			System.out.print(1+" ");
		
		if(fnMinus2==fnMinus1)
			System.out.print(1+" ");
	
		fn=fnMinus1+fnMinus2;
		fnMinus1=fnMinus2;
		fnMinus2=fn;
		System.out.print(fn+" ");
		
		n++;
		sum +=fn;
		
		
	}
	System.out.println();
	System.out.println(sum);
double avg=(double)sum/max;
System.out.println("Average of first "+max+" fibbonanci numbers is "+avg);
}
}
