package com.bizruntime.demo.excercise.patterns;

public class Pattern_d {
public static void main(String[] args) {
	
	printPatternX(10);
}
public static void printPatternX(int size){
	for (int row = 0; row < size; row++) {
		
		for (int space = 0; space < size-row; space++) {
			System.out.print("	");
		}
		for (int col = 0; col <row; col++) {
			System.out.print("#	");
		}
		System.out.println();
	}
}
}
