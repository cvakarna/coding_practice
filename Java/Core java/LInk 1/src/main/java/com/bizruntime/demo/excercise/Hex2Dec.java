package com.bizruntime.demo.excercise;

import java.util.Scanner;

public class Hex2Dec {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Hexadecimal  number");
		String str=sc.next();
		boolean val=checkHexaOrNot(str);
		int dec=0;
		if(val){
			dec=Hex2Dec(str);
		System.out.println("Value of Hexadecimal  "+str+" in decimal is "+dec);
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
	


	static int  Hex2Dec(String hexaStr){
		int hexaSrtLen=hexaStr.length();
		int dec=0;
		char hexaChar;
		int pow=hexaSrtLen-1;
		for (int i = 0; i < hexaSrtLen; i++) {
			 hexaChar=hexaStr.charAt(i);
			 
			 if(hexaChar>='0' && hexaChar <='9') 
					dec+=((hexaChar-'0')*Math.pow(16, pow--));
			 else if((hexaChar>='A' && hexaChar<='F'))
				dec+=((hexaChar-'A'+10)*Math.pow(16, pow--));
			else if((hexaChar>='a' && hexaChar<='f'))
				dec+=((hexaChar-'a'+10)*Math.pow(16, pow--));
			
		}
		
		return dec;
	}

	}
