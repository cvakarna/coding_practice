package com.bizruntime.demo.excercise.number.series;

public class Prime {
static 	int count;
	public static void main(String[] args) {
		boolean val=isPrime(812827);
		if(val)
		System.out.println("The given number is prime number");
		else
			System.out.println("The given number is not prime number");
		primeList(10000);
	}
	static boolean isPrime(int num){
		
		boolean val=true;
		int rootValue=(int) Math.sqrt(num);
		
		if(num==2)
			return true;
		if(num%2==0)
			return false;
		
		for (int i = 3; i <= Math.round(Math.sqrt(num)); i+=2) {
			if(num%i==0)
				return false;
		}
		return val;
	}
static void primeList(int max){
		
	
	for (int i = 1; i <= max; i++) {
		if(isPrime(i)){
			count++;
			System.out.print(i+"	");
		}
	}
	System.out.println("\n [ "+count+"  primes found ]");
	}
}
