package com.bizruntime.demo.excercise;

public class Product1ToN {
public static void main(String[] args) {

	product(1,1);
}
static void product(int first,int last){
	
	int product=1;
	
	System.out.println("Product of ");
	
	for (int i = product; i <= last; i++) {
		product *=i;
		if(i==last)
			System.out.println(i);
		else
			System.out.print(i +"*");
		
}
	
	System.out.println(product);

}	
}
