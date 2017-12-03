package com.bizruntime.demo;

public class Queue {

	protected LinkedList ll;

	public Queue() {
		ll = new LinkedList();
	}

	public boolean isEmpty() {
		return ll.isEmpty();
	}

	public void push(Object o) {
		ll.insert(o);
	}

	public Object pop() {
		return ll.removeEnd();
	}
}
