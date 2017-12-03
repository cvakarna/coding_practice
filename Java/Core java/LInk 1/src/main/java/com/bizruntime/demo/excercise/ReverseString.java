package com.bizruntime.demo.excercise;



public class ReverseString {
	
	public static void main(String[] args) {
	reverseString("I am living in bangalore");
	}

static void  reverseString(String sentence){
	int len=sentence.length();
for (int i = len-1; i >=0; i--) {
	System.out.print(sentence.charAt(i));
}
}
}
