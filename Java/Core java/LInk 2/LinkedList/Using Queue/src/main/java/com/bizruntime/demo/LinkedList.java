package com.bizruntime.demo;

public class LinkedList {

	protected Node head;
	protected int number;

	public LinkedList() {
		head = null;
		number = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return number;
	}

	public void insert(Object data) {
		head = new Node(data, head);
		number++;
	}

	public void insertEnd(Object obj) {

		if (isEmpty())
			insert(obj);
		else {

			Node temp1 = head;
			while (temp1.getNext() != null)
				temp1 = temp1.getNext();

			Node temp2 = new Node(obj, temp1.getNext());
			temp1.setNext(temp2);
			number++;
		}

	}

	public Object remove() {
		if (isEmpty())
			return null;
		Node tmp = head;
		head = tmp.getNext();
		number--;
		return tmp.getData();
	}

	public Object removeEnd() {

		if (isEmpty())
			return null;

		if (head.getNext() == null) {
			return remove();
		}
		Node temp1 = head;
		while (temp1.getNext().getNext() != null)
			temp1 = temp1.getNext();

		Object data = temp1.getNext().getData();
		temp1.setNext(temp1.getNext().getNext());
		number--;
		return data;

	}
	
	public Object peek(int n){
			Node temp = head;
	        for(int i = 0;i<n && temp != null;i++)
	            temp = temp.getNext();
	        return temp.getData();
	}
}
