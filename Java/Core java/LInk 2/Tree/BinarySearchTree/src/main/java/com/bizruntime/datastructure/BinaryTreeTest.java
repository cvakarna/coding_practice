package com.bizruntime.datastructure;

import org.apache.log4j.Logger;


public class BinaryTreeTest {

	static final Logger log=Logger.getLogger(BinaryTreeTest.class);
	static BinaryTree tree=new BinaryTree();
	
	
	public static void main(String[] args) {
		 
		
		log.info("Numbers insterted : ");
		insert(10);
		
		
		log.info("Pre-Order : ");
		tree.print(1);
		log.info("In-Order : ");
		tree.print();
		log.info("Post-Order : ");
		tree.print(3);

	}

	public static void insert(int max){
		
		CustomInteger num;
		for (int i = 0; i < max; i++) {
	
		tree.insert(num=new CustomInteger((int)(Math.random()*100)));
		log.info(num);
		}
	}
}
