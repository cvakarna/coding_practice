package com.chapter1;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public  class PolicyTestCases {

	@TestCase(willThrow = ArrayIndexOutOfBoundsException.class)
	public  void testCase1() {
		int []a=new int[10];
		int b=a[10];
		System.out.println(b);
	};


	@TestCase
	public static void testCase2() {

	}

	public static void main(String[] args) {
		PolicyTestCases testcase=new PolicyTestCases();
		testcase.testCase1();
	}
}

class Test extends PolicyTestCases {
	@Override
	public void testCase1() {
		System.out.println();
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TestCase {
	Class<? extends Throwable> willThrow() default DefaultException.class;
}

class DefaultException extends Throwable {

	public DefaultException() {
	}

	public DefaultException(String msg) {
		super(msg);
	}

}