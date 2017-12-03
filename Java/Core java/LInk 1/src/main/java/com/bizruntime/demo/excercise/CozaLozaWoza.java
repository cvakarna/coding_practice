package com.bizruntime.demo.excercise;

public class CozaLozaWoza {
public static void main(String[] args) {
	
	
	int first=1;
	int last=110;
	
	for (int num = 1; num <=last; num++) {
		
	
	/*	if(num%3==0 && num%5!=0 && num%7!=0)
			System.out.print("Coza ");
		if(num%5==0 && num%3!=0 && num%7!=0)
			System.out.print("Loza ");
		if(num%7==0 && num%3!=0 && num%5!=0)
			System.out.print("Woza ");
		if(num%3==0 && num %5==0 && num%7!=0 )
			System.out.print("CozaLoza ");
		if(num%3==0 && num %7==0 && num%5!=0)
		System.out.print("CozaWoza ");
		if(num%3==0 && num %7==0 && num%5==0)
			System.out.print("CozaLozaWoza ");
			
		if(num%3!=0 && num%5!=0 && num%7!=0)
			System.out.print(num+" ");
		 
		if(num%11==0)
				System.out.println();
		
		*/
		
		if(num%3==0){
			if(num%5!=0){
				if(num%7!=0){
					System.out.print("Coza ");
				}else 
					System.out.println("CozaWoza");
			}else
				System.out.println("CozaLoza");
		}else if(num%5==0){
			if(num%3!=0){
				if(num%7!=0){
					System.out.print("Loza ");
				}else 
					System.out.println("LozaWoza");
			}else
				System.out.println("CozaLoza");
		
			}else if(num%7==0){	
				if(num%3!=0){
				if(num%5!=0){
					System.out.print("Coza ");
				}else 
					System.out.println("CozaWoza");
			}else
				System.out.println("CozaLoza");
		
		}
		
		if(num%5!=0 && num%3==0 && num%7!=0)
				System.out.print("Coza ");
		if(num%5==0 && num%3!=0 && num%7!=0)
			System.out.print("Loza ");
		if(num%7==0 && num%3!=0 && num%5!=0)
			System.out.print("Woza ");
		if(num%3==0 && num %5==0 && num%7!=0 )
			System.out.print("CozaLoza ");
		if(num%3==0 && num %7==0 && num%5!=0)
		System.out.print("CozaWoza ");
		if(num%3==0 && num %7==0 && num%5==0)
			System.out.print("CozaLozaWoza ");
			
		if(num%3!=0 && num%5!=0 && num%7!=0)
			System.out.print(num+" ");
		 
		if(num%11==0)
				System.out.println();
		
		
		
	}
	
	
}
}
