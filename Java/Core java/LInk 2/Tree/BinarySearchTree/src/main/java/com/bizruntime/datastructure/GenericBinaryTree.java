package com.bizruntime.datastructure;

import org.apache.log4j.Logger;



public abstract class GenericBinaryTree {

	private TwoChildNode root;
	
	static final Logger log=Logger.getLogger(BinaryTreeTest.class);
	
	public GenericBinaryTree() {
		setRoot(null);
	}

	public GenericBinaryTree(Object o) {
		setRoot(new TwoChildNode(o));
	}

	protected void setRoot(TwoChildNode r) {
		root = r;
	}

	protected TwoChildNode getRoot() {
		return root;
	}

	public boolean isEmpty() {
		return getRoot() == null;
	}

	public Object getData() {
		if (!isEmpty())
			return getRoot().getData();
		return null;
	}

	public void setData(Object o) {
		if (!isEmpty())
			getRoot().setData(o);
	}

	public TwoChildNode getLeft() {
		if (!isEmpty())
			return getRoot().getLeft();
		return null;
	}

	public TwoChildNode getRight() {
		if (!isEmpty())
			return getRoot().getRight();
		return null;
	}

	public void insertLeft(TwoChildNode p, Object o) {
		if ((p != null) && (p.getLeft() == null))
			p.setLeft(new TwoChildNode(o));
	}

	public void insertRight(TwoChildNode p, Object o) {
		if ((p != null) && (p.getRight() == null))
			p.setRight(new TwoChildNode(o));
	}

	public void print(int mode) {
		if (mode == 1)
			pretrav();
		else if (mode == 2)
			intrav();
		else if (mode == 3)
			postrav();
	}

	public void pretrav() {
		pretrav(getRoot());
	}

	protected void pretrav(TwoChildNode p) {
		if (p == null)
			return;
		log.info(p.getData() + " ");
		pretrav(p.getLeft());
		pretrav(p.getRight());
	}

	public void intrav() {
		intrav(getRoot());
	}

	protected void intrav(TwoChildNode p) {
		if (p == null)
			return;
		intrav(p.getLeft());
		log.info(p.getData() + " ");
		intrav(p.getRight());
	}

	public void postrav() {
		postrav(getRoot());
	}

	protected void postrav(TwoChildNode p) {
	
		if (p == null)
			return;
		postrav(p.getLeft());
		postrav(p.getRight());
		log.info(p.getData() + " ");
	}
}
