package com.bizruntime.demo.excercise;

public class Tribonacci {

	public static void main(String[] args) {
		
		int tnMinus1=1;
		int tnMinus2=1;
		int tnMinus3=2;
		int tn=0;
		
		
		int sum=tnMinus1+tnMinus2+tnMinus3;
		
		int max=30;
		int index=4;
		
		System.out.println("the first "+max+" tribonacci series is ");
		while(index<=10){
			if(tnMinus1==tnMinus2)
				System.out.print(tnMinus1+" ");
			if(tnMinus1==1 && tnMinus2==1)
				System.out.print(tnMinus1+" ");
			if(tnMinus3==2)
				System.out.print(2+" ");
			tn=tnMinus3+tnMinus2+tnMinus1;
			tnMinus1=tnMinus2;
			tnMinus2=tnMinus3;
			tnMinus3=tn;
		System.out.print(tn+" ");	
			sum +=tn;
			
			index++;
		}
		
		System.out.println("\nsum of first "+max+" tribonacci series is "+sum);
	}
	
}
