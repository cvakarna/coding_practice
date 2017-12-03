package com.bizruntime.demo.excercise;

public class MultiplicationTable {
public static void main(String[] args) {
	
	int first=1;
	int last=12;
	
	for (int i = first; i <=last; i++) {
		if(i==1){
			System.out.printf("%4c",'x');
			System.out.printf("%4c", '|');
			System.out.printf("%4d",i);
			
			}
		
			else
				System.out.printf("%4d",i);	
	}
	System.out.println("\n---------------------------------------------------");
	for (int i = first; i <= last ; i++) {
		for (int j = first; j <= last ; j++) {
			System.out.printf("%4d",i*j);
		}
		System.out.printf("%n");
	}
}



}
