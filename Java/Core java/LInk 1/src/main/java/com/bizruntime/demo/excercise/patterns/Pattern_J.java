package com.bizruntime.demo.excercise.patterns;


public class Pattern_J {
	
	
public static void main(String[] args) {
	
	printPatternX(10);
}

public static void printPatternX(int size){
	
	for (int row = 1; row <=size; row++) {
			for (int col = 1; col <=size-row; col++) {
				if(col>=row)
					System.out.print("#	");
				else
					System.out.print("	");
			}
			
				System.out.println();
	}
}
}
