package com.bizruntime.demo.excercise;

public class Example1 {

	public static void main(String[] args) {
		
			double sum=0;
			int first=1,last=100;
			double avg=0.0;
			int count=0;
			for (int i = first; i <=last; i++) {
		sum+=(i);
				count++;
			}
			System.out.println("sum of "+last+" is "+sum);
			avg=sum/count;
			System.out.println("average of sum is "+avg);

			sum=0;count=0;
			int num=first;
			while(num<=last){
					sum+=(num);
					count++;
				num++;
			}
		System.out.println("sum of "+last+" is "+sum);
		avg=sum/count;
		System.out.println("average of sum is "+avg);

			num=first;sum=0;count=0;
			do{
				sum+=(num);
				count++;
			
				num++;
				
			}while(num<=last);
	System.out.println("sum of "+last+" is "+sum);
	
	
	avg=sum/count;
	
	System.out.println("average of sum is "+avg);
	}
	
	
}
