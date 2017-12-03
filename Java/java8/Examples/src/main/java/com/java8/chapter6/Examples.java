package com.java8.chapter6;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Examples {
	public static void main(String[] args) {
	//	foreach();
	//	map();
	//	filter();
	//	limit();
	//Collectors joining
	//	joining();
		
	//Statistics
		summarStatistics();
	}

	private static void summarStatistics() {
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
	}

	private static void joining() {
		List<String> numbers = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		System.out.println(numbers.stream().filter(i->!i.isEmpty()).sorted().collect(Collectors.joining(",")));

	}

	private static void limit() {
		List<Integer> numbers = Arrays.asList(2,34,4,10,3, 2, 2, 3, 12,7, 3, 51,1);
		System.out.println(numbers.stream().filter(i->i>5).sorted().collect(Collectors.toList()));
	}

	private static void filter() {
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		System.out.println(numbers.stream().filter(i->i>5).collect(Collectors.toList()));
		
	}

	private static void map() {
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		System.out.println(numbers.stream().map(i->i*i).collect(Collectors.toList()));
	}

	private static void foreach() {
		Random 	ran=new Random();
		ran.ints().limit(10).forEach(System.out::println);
}
}
