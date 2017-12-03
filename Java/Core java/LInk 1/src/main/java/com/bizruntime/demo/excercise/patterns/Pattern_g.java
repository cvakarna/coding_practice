package com.bizruntime.demo.excercise.patterns;

public class Pattern_g {
public static void main(String[] args) {
	
	printPatternX(10);
}

public static void printPatternX(int size){
	for (int row = 0; row <size; row++) {
			for (int col = 0; col <size; col++) {
				 if(row==0 || row==size-1||row+col==size-1)
					System.out.print("#	");
				 else
					 System.out.print("	");
		}
		System.out.println();
	}
}
}
