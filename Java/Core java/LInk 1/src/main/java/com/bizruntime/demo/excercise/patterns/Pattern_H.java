package com.bizruntime.demo.excercise.patterns;


public class Pattern_H {
	
	
public static void main(String[] args) {
	
	printPatternX(10);
}

public static void printPatternX(int size){
	
	for (int row = 1; row <=size; row++) {
			for (int col = 1; col <=size; col++) {
				 if(row<1||row==size ||row==col||row+col==size+1){
					System.out.print("#	");
					continue;
				 }
				 
					 System.out.print("	");
		}
		System.out.println();
	}
}
}
