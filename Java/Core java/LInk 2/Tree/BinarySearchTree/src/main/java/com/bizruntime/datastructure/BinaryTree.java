package com.bizruntime.datastructure;

public class BinaryTree extends GenericBinaryTree {

	protected BinaryTree() {
		
	}

	public BinaryTree(Object o) {
		super(o);
	}

	public void print() {
		print(2);
	}

	public void insert(CustomComparable cc) {
		TwoChildNode t, q;
		for (q = null, t = getRoot(); t != null
				&& cc.compareTo(t.getData()) != 0; q = t, t = cc.compareTo(t
				.getData()) < 0 ? t.getLeft() : t.getRight()) ;

			if (t != null)
				return;
			else if (q == null)
				setRoot(new TwoChildNode(cc));
			else if (cc.compareTo(q.getData()) < 0)
				insertLeft(q, cc);
			else
				insertRight(q, cc);
			

		

	}

}
