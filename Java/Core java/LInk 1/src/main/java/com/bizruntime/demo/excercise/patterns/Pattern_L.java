package com.bizruntime.demo.excercise.patterns;


public class Pattern_L {
	
	
public static void main(String[] args) {
	
	printPatternX(10);
}

public static void printPatternX(int size){
	
	for (int row = 1; row <=2*size; row++) {
			for (int col = 1; col <=size-1; col++) {
				if(row+col>=size+1 && col-row<=size-1){
					System.out.print("#	");
					continue;
				}
					System.out.print("	");
			}
			for (int col = size; col >row-1; col++) {
				if(row+col>=size+1 && col-row<=size-1){
					System.out.print("#	");
					continue;
				}
					System.out.print("	");
			}
				System.out.println();
	}
}
}
