package com.bizruntime.demo.excercise;

public class ExtractingDigits {
public static void main(String[] args) {
	
	int num=1542;
	int temp=num;
	int rev;
	System.out.print("Reverse of number  "+num+" is ");
	while(temp>0){
	
		rev=temp%10;
		
		temp=temp/10;
		if(temp<=0)
			System.out.print(rev);
		else
	System.out.print(rev+",");
	}
	
}
}
