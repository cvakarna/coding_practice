package com.bizruntime.demo.excercise.methods;

import java.util.Scanner;

public class GradeStatitics {
	static int grades[];
	
public static void main(String[] args) {
	
	
	readGrades();
    System.out.println("The average is " + average());
    System.out.println("The minimum is " + min());
    System.out.println("The maximum is " + max());
    System.out.println("The standard deviation is " + stdDev());
 
}

private static double stdDev() {

	int sumOfPow=0;
	int sum=0;
	for (int i = 0; i < grades.length; i++) {
		sumOfPow +=Math.pow(grades[i],2);
		sum +=grades[i];
	}
	double sd= (((double)sumOfPow/grades.length)-Math.pow((double)sum/grades.length, 2));
	return Math.sqrt(sd);
}

private static int max() {
	int max=0;
	max=grades[0];
	for (int i = 0; i < grades.length-1; i++) {
	max=grades[i]>max?grades[i]:max;
	}
	return max;
}

private static int min() {
	int min=grades[0];
	for (int i = 0; i < grades.length-1; i++) {
		min=grades[i]<min?grades[i]:min;		
	}
		return min;
	}

private static double average() {
	
	int len=grades.length;
	int  sum=0;
	double avg;
	for (int i = 0; i < len; i++) {
		sum+=grades[i];
	}
	avg=sum/len;
	return avg;
}


private static void readGrades() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter numbr of students");

	int newStudents=sc.nextInt();
	
	grades=new int[newStudents];

	boolean val=true;
	for (int i = 0; i < grades.length; i++) {
		while(val){
			System.out.println("Enter grade of Student"+(i+1));
			grades[i]=sc.nextInt();
			if(!(grades[i]>=0 && grades[i]<=100))
			{
				val=true;
				System.out.println("Try again");
			}else{
			val=false;
			}
		}
	val=true;
	}

	
}


}
