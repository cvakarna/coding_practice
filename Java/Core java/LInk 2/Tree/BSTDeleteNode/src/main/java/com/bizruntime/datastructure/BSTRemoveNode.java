package com.bizruntime.datastructure;

import org.apache.log4j.Logger;

public class BSTRemoveNode {

	static BSTRemoveNode tree = null;
	static int[] numbers = { 56, 86, 71, 97, 82, 99, 65, 36, 16, 10, 28, 52, 46 };

	public  BSTRemoveNode left, right;
	public  Comparable data;

	static Logger log = Logger.getLogger(BSTRemoveNode.class);

	public static void main(String[] args) {

		toInsert();
		toPrint();
		toRemove();
	}

	static void toInsert() {
		log.debug("inserting....\n");
		for (int i = 0; i < numbers.length; i++) {
			Integer n = new Integer(numbers[i]);
			log.info(" " + n);
			tree = tree_AddNumber(tree, n);
		}

	}

	static void toPrint() {
		log.debug("\ntree: ");

		treeInOrderPrint(tree);
	}


	static void toRemove() {
		for (int j = 0; j < numbers.length; j++) {
			Integer n = new Integer(numbers[j]);
			log.info("\nremove: " + n + " tree: ");
			tree = treeRemoveNumber(tree, n);
			treeInOrderPrint(tree);
		}
	}

	 public static BSTRemoveNode tree_AddNumber(
		        BSTRemoveNode r,Comparable n){
		        if(r == null){
		            r = new BSTRemoveNode();
		            r.left = r.right = null;
		            r.data = n;
		        }else if(r.data.compareTo(n) < 0)
		            r.right = tree_AddNumber(r.right,n);
		        else if(r.data.compareTo(n) > 0)
		            r.left = tree_AddNumber(r.left,n);
		        return r;
		    }

	
	private static void treeInOrderPrint(BSTRemoveNode node) {
		if(node!=null){
			treeInOrderPrint(node.left);
			log.info("	"+node.data);
			treeInOrderPrint(node.right);
		}
	}
	
	public static BSTRemoveNode treeRemoveNumber(BSTRemoveNode r, Comparable n) {
		
		if(r!=null){
		
			if(r.data.compareTo(n) < 0){
                r.right = treeRemoveNumber(r.right,n);
            }else if(r.data.compareTo(n) > 0){
                r.left = treeRemoveNumber(r.left,n);
            }else{
                if(r.left == null && r.right == null){
                    r = null;
                }else if(r.left != null && r.right == null){
                    r = r.left;
                }else if(r.right != null && r.left == null){
                    r = r.right;
                }else{
                    if(r.right.left == null){
                        r.right.left = r.left;
                        r = r.right;
                    }else{
                        BSTRemoveNode q,p = r.right;
                        while(p.left.left != null)
                            p = p.left;
                        q = p.left;
                        p.left = q.right;
                        q.left = r.left;
                        q.right = r.right;
                        r = q;
                    }
                }
            }
			
		}
		
		return r;
	}	
}
