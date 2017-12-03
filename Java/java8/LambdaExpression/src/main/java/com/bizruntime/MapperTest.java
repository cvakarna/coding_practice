package com.bizruntime;

import org.apache.log4j.Logger;

public class MapperTest {
	private static Logger log=Logger.getLogger(Example1.class);
	public static void main(String[] args) {
		log.debug("Mapping names to their lengths:");
		String[] names = { "David", "Li", "Doug" };
		
		int[] lengthMapping = Mapper.mapToInt(names , (String name) -> name.length());

		printMapping(names, lengthMapping);
		log.debug("\nMapping integers to their squares:");
		Integer[] numbers = {7, 3, 67};
		int[] countMapping = Mapper.mapToInt(numbers, (Integer n) -> n * n);
		printMapping(numbers, countMapping);
		
	}

	public static void printMapping(Object[] from, int[] to) {
		for (int i = 0; i < from.length; i++) {
			log.debug(from[i] + " mapped to " + to[i]);
		}
	}
}

@FunctionalInterface
interface Mapper<T> {
	int map(T source);

	public static <U> int[] mapToInt(U[] list, Mapper<? super U> mapper) {
		int[] mappedValues = new int[list.length];

		for (int i = 0; i < list.length; i++) {
			mappedValues[i] = mapper.map(list[i]);
		}

		return mappedValues;
	}
}