package com.java8.lambda;

import java.util.Comparator;
import java.util.Currency;
import java.util.List;

public class Apple implements Comparator<Apple> {

	private Integer weight;

	public Integer getWeight() {
		
		return weight;
	
	
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public int compare(Apple a1, Apple a2) {
		return a1.getWeight().compareTo(a2.getWeight());
	}

	
}
