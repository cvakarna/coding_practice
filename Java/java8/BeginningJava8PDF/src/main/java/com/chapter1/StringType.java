package com.chapter1;

// Annotation 
@interface Name {
	String first();

	String last();
}

@Name(first = "John", last = "Jacobs")
class NameTest {
	@Name(first = "Wally", last = "Inman")
	public void aMethod() {

	}
}

public class StringType {

}
