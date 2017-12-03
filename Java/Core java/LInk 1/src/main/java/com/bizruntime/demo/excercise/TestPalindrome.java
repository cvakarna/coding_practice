package com.bizruntime.demo.excercise;

import java.util.Scanner;

public class TestPalindrome {
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	String str=sc.nextLine();
	boolean val=palindromeOrNot(str);
	if(val==true)
		System.out.println("Given String "+str+" is palindrome");
	else
		System.out.println("Given String is not palindrome");

}
static boolean palindromeOrNot(String str){
		boolean val=true;
		int len=str.length();
		str=str.toLowerCase();
		StringBuffer sb=new StringBuffer();
		
		for (int i = 0; i < len; i++) {
				char ch=str.charAt(i);	
				if(ch>=97 && ch<=122)
					sb.append(ch);
			}
		String str1=sb.toString();
		char[] arr=str1.toCharArray();

		
		int i = 0;
		int j = arr.length-1;

		while (val ){
				if(j>i){
				if(arr[i]!=arr[j]){
							val=false;
							break;
				}else
					i++;j--;
			}else
					break;
			}				
			return val;
}

}
