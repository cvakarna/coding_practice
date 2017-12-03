package com.bizruntime.demo.excercise.patterns;

public class Pattern_e {
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
				if(col==0  || col==size-1)
					System.out.print("#	");
				else
					System.out.print("	");
		}
		System.out.println();
	}
}
}
