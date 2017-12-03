package com.bizruntime.demo.excercise.patterns;

public class Matrix {
public static void main(String[] args) {
	
	Matrix matrix=new Matrix();
	int [][]arr1={{1,2},{3,4},{5,6,1}};
	
	System.out.println("Integer  matrixes : ");
	printMatrix(arr1);
	double [][]arr2={{1.0,2.0},{3.0,4.0},{5.0,6.0,1.0}};

	System.out.println("Double  matrixes :");
	printMatrix(arr2);

	int [][]arr3={{1,2},{3,4},{5,6,1,4}};
	
	
	double [][]arr4={{1.0,2.0},{3.0,4.0,},{5.0,6.0,1.0}};

	if(haveSameDimension(arr1, arr3)){
		System.out.println("Given arr1 & arr2 have same dimensions ");
	}else {
		System.out.println("Given arr1 & arr2 doesn't have same dimensions ");
	}	
	
	if(haveSameDimension(arr2, arr4))
		System.out.println("Given arr2 & arr4 have same dimensions ");
	else 
		System.out.println("Given arr4 & arr4 doesn't have same dimensions ");
	
	
	System.out.println("Addition of two dimensional array int matrixes with same length  ");
	int result1[][]=add(arr1, arr1);
	printMatrix(result1);
	
	
	System.out.println("Addition of 2-D double matrixes ");
	double result2[][]=add(arr2, arr4);
	printMatrix(result2);
	


}
public static void printMatrix(int[][] m) {
	for (int i = 0; i < m.length; i++) {
		for (int j = 0; j < m[i].length; j++) {
			System.out.print(m[i][j]+"	");
		}
		System.out.println();
	}
}
public static void printMatrix(double[][] m) { 
	
for (int i = 0; i < m.length; i++) {
	for (int j = 0; j < m[i].length; j++) {
		System.out.print(m[i][j]+"	");
	}
	System.out.println();
}
}
public static boolean haveSameDimension(int[][] m1, int[][] m2) {  
	
	if(m1.length!=m2.length){
		return false;
	}else{
	for (int i = 0; i < m1.length ; i++) {
			if(m1[i].length!=m2[i].length)
					return false;
	}
}
	return true;
}
public static boolean haveSameDimension(double[][] m1, double[][] m2) {
	if(m1.length!=m2.length){
		return false;
	}else{
	for (int i = 0; i < m1.length ; i++) {
			if(m1[i].length!=m2[i].length)
					return false;
	}
}
	return true;	
}

public static int[][] add(int[][] m1, int[][] m2) {
	int [][]add=new int[m1.length][];
	
	for (int i = 0; i < m1.length; i++) {
		add[i]=new int[m1[i].length];
		for (int j = 0; j < m1[i].length; j++) {
			add[i][j]=m1[i][j]+m2[i][j];
		}
	}
	
	return add;
}

public static double[][] add(double[][] m1, double[][] m2) { 
double [][]add=new double[m1.length][];
	
	for (int i = 0; i < m1.length; i++) {
		add[i]=new double[m1[i].length];
		for (int j = 0; j < m1[i].length; j++) {
			add[i][j]=m1[i][j]+m2[i][j];
		}
}
return add;
}

public static int[][] multiply(int[][] m1, int[][] m2) {
	int [][]mul=new int[m1.length][];
	
	for (int i = 0; i < m1.length; i++) {
		mul[i]=new int[m1[i].length];
		for (int j = 0; j < m1[i].length; j++) {
			mul[i][j]=m1[i][j]*m2[i][j];
		}
	}
	
	return mul;
}


}
