package com.java8.chapter6;

import java.util.Date;
import java.util.stream.Stream;

public class ParallelExecution {
	public static void main(String[] args) {
		ParallelExecution par = new ParallelExecution();
		par.test();
	}

	private void test() {
		System.out.println(new Date().getTime()/1_00_000);
		System.out.println(iterativeSum(1000000));
		System.out.println(new Date().getTime());
		System.out.println(parallelSum(1000000L));
		System.out.println(new Date().getTime());

	}

	public static long iterativeSum(long n) {
		long result = 0;
		for (long i = 1L; i <= n; i++) {
			result += i;
		}
		return result;
	}

	public static long parallelSum(Long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
	}
}
