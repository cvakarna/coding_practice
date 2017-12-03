package com.bizruntime.demo;

public class Node {

	protected Object data;
	protected Node next;
	
	public Node() {
		this.data=null;
		this.next=null;
	}
	public Node(Object data, Node next) {
		this.data=data;
		this.next=next;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+data;
	}


}
