package com.chapter1;

import com.chapter1.Review.ReviewStatus;


//@Review()
//@Review(comments="Have scheduled code review on June 3 2014")
//@Review(status = ReviewStatus.PASSED)
@Review(status = ReviewStatus.FAILED, comments = "Need to handle errors")
public class EnumType {
	public static void main(String[] args) {

	}

	void test() {

	}
}

// Declaring Annotation
@interface Review {
	ReviewStatus status() default ReviewStatus.PENDING;

	String comments() default "";

	enum ReviewStatus {
		PENDING, FAILED, PASSED, PASSEDWITHCHANGES
	};
}