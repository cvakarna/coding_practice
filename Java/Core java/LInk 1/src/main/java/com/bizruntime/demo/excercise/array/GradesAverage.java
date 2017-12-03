package com.bizruntime.demo.excercise.array;

import java.util.Scanner;

public class GradesAverage {
public static void main(String[] args) {
	
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter numbr of students");
	int newStudents=sc.nextInt();
	int grades[]=new int[newStudents];
	boolean val=true;
	double avg=0.0;
	int sum=0;
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
			sum+=grades[i];
			}
		}
	val=true;
	}
	
	avg=sum/newStudents;
	System.out.println("The average is  :"+avg);
	
}
}
