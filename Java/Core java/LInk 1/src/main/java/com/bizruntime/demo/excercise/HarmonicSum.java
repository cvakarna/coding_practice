package com.bizruntime.demo.excercise;

public class HarmonicSum {
public static void main(String[] args) {

	harmonicSum(10);
}

static void harmonicSum(int last){
	
	double sum1 = 0.0, sum2=0.0;
	System.out.println("Sum from left to right");
	for(int denominator=1;denominator <= last; denominator++){
		
		sum1 += (double)1/denominator;
	}
	System.out.println(sum1);
	System.out.println("Sum from right to left");
	for(int denominator=last;denominator>=1;denominator--){
		sum2 +=(double)1/denominator;
	}
	System.out.println(sum2);

}

}
