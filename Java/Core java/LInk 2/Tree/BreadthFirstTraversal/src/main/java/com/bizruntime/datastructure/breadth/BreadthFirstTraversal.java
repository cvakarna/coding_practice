package com.bizruntime.datastructure.breadth;

import org.apache.log4j.Logger;

import com.bizruntime.datastructure.BinaryTree;
import com.bizruntime.datastructure.BinaryTreeTest;
import com.bizruntime.datastructure.TwoChildNode;
import com.bizruntime.demo.Queue;


public class BreadthFirstTraversal extends BinaryTree {
	
	static final Logger log=Logger.getLogger(BinaryTreeTest.class);

	public void breadth_first(){
	Queue q=new Queue();
	TwoChildNode temp;
	
	q.insert(getRoot());
	while(!q.isEmpty()){
		temp =(TwoChildNode) q.remove();
		if(temp.getLeft() != null)
			q.insert(temp.getLeft());
		  if(temp.getRight() != null)
              q.insert(temp.getRight());
		  log.info(temp.getData()+" ");
	}
	}
	
	
	
	
	
	
	
	
}
