package com.bizruntime.demo.excercise;

import java.util.Scanner;

public class Bin2Dec {
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the binary number");
	String str=sc.next();
	int num=Integer.parseInt(str);
	boolean val=checkBinaryOrNot(num);
	int dec=0;
	if(val){
		dec=bin2Dec(str);
	System.out.println("Value of Binary  "+str+" in decimal is "+dec);
	}
}

static boolean checkBinaryOrNot(int num) {
int temp=num;
	
	if(temp!=0){
		int rem=0;
		while(temp>0){
		rem=temp%10;
		if(rem>1){
				System.out.println("Enter a valid Binary Number");
				return false;
		}
			temp=temp/10;
		}
	}
	return true;
}


static int  bin2Dec(String binStr){
	int binSrtLen=binStr.length();
	int dec=0;
	char binChar;
	int pow=binSrtLen-1;
	for (int i = 0; i < binSrtLen; i++) {
		 binChar=binStr.charAt(i);
		if(binChar=='1'){
			dec += (int)Math.pow(2,pow--);
		}else
			pow--;
	}
	
	return dec;
}

}
