package com.bizruntime.demo.excercise.patterns;

public class Pattern_f {
public static void main(String[] args) {
	
	printPatternX(10);
}

public static void printPatternX(int size){
	for (int row = 0; row < size; row++) {
		if(row==0 || row==size-1)
			for (int i = 0; i <size; i++) 
				System.out.print("#	");
		else
			for (int col = 0; col <size; col++) {
				 if(row==col)
					System.out.println("#");
				else
					System.out.print("	");
		}
		System.out.println();
	}
}
}
