package com.java8.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BeforeLamda {

	public static void main(String[] args) {
		
		Apple apple1=new Apple();
		Apple apple2=new Apple();

		apple1.setWeight(200);
		apple2.setWeight(100);
		
		Comparator<Apple>  comp=new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}		
		};
		
		List<Apple> list=new  ArrayList<Apple>();
		list.add(apple1);
		list.add(apple2);
		
		for(Apple a:list){
			System.out.println(a.getWeight());
		}	
		
	}
}
