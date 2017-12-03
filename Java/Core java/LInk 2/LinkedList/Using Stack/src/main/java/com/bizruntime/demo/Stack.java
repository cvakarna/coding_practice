package com.bizruntime.demo;

public class Stack {

	protected LinkedList ll;

	public Stack() {
		ll = new LinkedList();
	}

	public boolean isEmpty() {
		return ll.isEmpty();
	}

	public void push(Object o) {
		ll.insert(o);
	}

	public Object pop() {
		return ll.remove();
	}
}
