package com.bizruntime.demo.excercise.array;

import java.util.Scanner;

public class Hex2B {
public static void main(String[] args) {
	String hexBits[]={"0000","0001","0010","0011",
										"0100","0101","0110","0111",
										"1000","1001","1010","1011",
										"1100","1101","1110","1111"
										};
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter  Hexa decimal number");
		String hexStr=sc.next();
	System.out.println('0'-'0');
	boolean val=checkHexaOrNot(hexStr);
	int dec=0;
	if(val){
		System.out.println("Value of Hexadecimal  "+hexStr+" in binary is ");
		for (int i = 0; i < hexStr.length(); i++) {
			char hexChar=hexStr.charAt(i);
			if(hexChar>='0'&&hexChar<='9')
			{
				System.out.print(hexBits[(hexChar-'0')]+"	");
			}
			else if((hexChar>='a'&&hexChar<='f')||(hexChar>='A'&&hexChar<='F'))
			{
				System.out.print(hexBits[(hexChar-'a'+10)]+"	");
			}
		}
	}
}

static boolean checkHexaOrNot(String str) {
	boolean val=true;
for(int i=0;i<str.length();i++){
		char ch=str.charAt(i);
		int num=ch;
		if(!((ch>='0' && ch<='9')||(ch>='a' && ch <='f')||(ch>='A' && ch <='F')))
		{
			System.out.println("Enter a valid Hexa Decimal number");
			val=false;
			break;
		}
}
	return val;
}

}
