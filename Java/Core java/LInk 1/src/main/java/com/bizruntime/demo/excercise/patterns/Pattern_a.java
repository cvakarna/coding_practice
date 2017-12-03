package com.bizruntime.demo.excercise.patterns;

public class Pattern_a {
public static void main(String[] args) {
	
	printPatternX(10);
}
public static void printPatternX(int size){
	for (int row = 0; row < size; row++) {
		for (int col = 0; col <= row; col++) {
			System.out.print("#	");
		}
		System.out.println();
	}
}
}
