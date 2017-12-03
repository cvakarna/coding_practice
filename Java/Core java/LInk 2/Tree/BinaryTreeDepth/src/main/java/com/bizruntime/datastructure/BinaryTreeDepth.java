package com.bizruntime.datastructure;

import org.apache.log4j.Logger;

public class BinaryTreeDepth {

	static Logger log = Logger.getLogger(BinaryTreeDepth.class);
	static BinaryTreeDepth tree = null;
	public BinaryTreeDepth left, right;
	public Comparable data;
    public static int[] numbers = {7,3,11,2,5,9,12,4,6,8,10};

	private static int tree_depth,curr_depth = 0;

	
	
	public static void main(String[] args) {

		toInsert();
		toPrint();
		log.info("\n depth : "+getDepth(tree));
	
	}

	static void toInsert() {
		log.debug("inserting....\n");
		for (int i = 0; i < 10; i++) {
			Integer n = new Integer(numbers[i]);
			log.info(" " + n);
			tree = tree_AddNumber(tree, n);
		}

	}

	static void toPrint() {
		log.debug("\ntree: ");

		treeInOrderPrint(tree);
	}

	public static BinaryTreeDepth tree_AddNumber(BinaryTreeDepth r, Comparable n) {
		if (r == null) {
			r = new BinaryTreeDepth();
			r.left = r.right = null;
			r.data = n;
		} else if (r.data.compareTo(n) < 0)
			r.right = tree_AddNumber(r.right, n);
		else if (r.data.compareTo(n) > 0)
			r.left = tree_AddNumber(r.left, n);
		return r;
	}

	private static void treeInOrderPrint(BinaryTreeDepth node) {
		if (node != null) {
			treeInOrderPrint(node.left);
			log.info("	" + node.data);
			treeInOrderPrint(node.right);
		}
	}

	public static int getDepth(BinaryTreeDepth r) {
		tree_depth = 0;
		_getDepth(r);
		return tree_depth;
	}
	public static void _getDepth(BinaryTreeDepth r){
        if(r != null){
            curr_depth++;
            if(curr_depth > tree_depth)
                tree_depth = curr_depth;
            _getDepth(r.left);
            _getDepth(r.right);
            curr_depth--;
        }
    }


}
