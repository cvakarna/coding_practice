package com.chapter1;

@Version(major = 1, minor = 0)
public class Example1 {

	@Version(major = 1, minor = 0)
	private int xyz = 110;

}

@interface Version{

	int major();
	int minor();
	
}