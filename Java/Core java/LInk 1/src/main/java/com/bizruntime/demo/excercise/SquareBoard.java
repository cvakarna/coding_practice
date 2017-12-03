package com.bizruntime.demo.excercise;

public class SquareBoard {

	public static void main(String[] args) {
		int size=7;
	for (int i = 1; i <=size; i++) {
		if(i%2!=0)
			System.out.print(" ");
		for (int j = 1; j <= size; j++) {
			System.out.print("# ");
		}
		System.out.println();
	}
	
	}
}
