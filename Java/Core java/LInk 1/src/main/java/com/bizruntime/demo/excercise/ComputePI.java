package com.bizruntime.demo.excercise;

public class ComputePI {
public static void main(String[] args) {
	
	double sum=computePI(12);
	System.out.println("computed pi value "+4*sum);
}
static double computePI(int maxDemo){
	
	double sum=0;
	
	for (int denom= 1; denom <= maxDemo; denom=denom+2) {
		
		if(denom%4==1)
			sum +=(double)1/denom;
		if(denom%4==3)
			sum -=(double)1/denom;
	}
	
	System.out.println(sum);
	return sum;
}
}
