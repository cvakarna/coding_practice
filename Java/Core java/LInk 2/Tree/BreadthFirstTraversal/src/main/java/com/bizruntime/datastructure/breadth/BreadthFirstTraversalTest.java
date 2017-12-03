package com.bizruntime.datastructure.breadth;

import org.apache.log4j.Logger;

import com.bizruntime.datastructure.BinaryTree;
import com.bizruntime.datastructure.BinaryTreeTest;
import com.bizruntime.datastructure.CustomInteger;
import com.bizruntime.datastructure.TwoChildNode;
import com.bizruntime.demo.Queue;


	
public class BreadthFirstTraversalTest  {
	static final Logger log=Logger.getLogger(BinaryTreeTest.class);

	static BreadthFirstTraversal tree=new BreadthFirstTraversal();
	public static void main(String[] args) {
		 
		
		log.info("Numbers insterted : ");
		insert(10);
		
		
		log.info("Pre-Order : ");
		tree.print(1);
		log.info("In-Order : ");
		tree.print();
		log.info("Post-Order : ");
		tree.print(3);
		log.info("Breadth-first Traversal : ");
		tree.breadth_first();

	}

	public static void insert(int max){
		
		CustomInteger num;
		for (int i = 0; i < max; i++) {
	
		tree.insert(num=new CustomInteger((int)(Math.random()*100)));
		log.info(num);
		}
	}
	
	
	
	
	
	
	
	
}
