package com.bizruntime.demo.excercise.methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GradesHistogram {
	   public static int[] grades;

	   public static int[] bins = new int[10];
	   
	   public static void main(String[] args) throws FileNotFoundException {
		      readGrades("grades.in");
		      computeHistogram();
		      printHistogramHorizontal();
		      printHistogramVertical();
		   }
	   public static void readGrades(String filename) throws FileNotFoundException { 
		   	
		   Scanner sc=new Scanner(new File(filename));
		   int numberOfSubjects=sc.nextInt();
		   
		   grades=new int[numberOfSubjects];
		   
		   for (int i = 0; i < grades.length; i++) {
			grades[i]=sc.nextInt();
		}
		   
		   
		   
	   }
	   public static void computeHistogram() {}
	   public static void printHistogramHorizontal() { }
	   public static void printHistogramVertical() { }

}
