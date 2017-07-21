package com.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author navneet
 * @since 20-Jul-2017
 * @version 
 * 
 * Print extreme nodes of each level of Binary Tree in alternate order
 * http://www.geeksforgeeks.org/print-extreme-nodes-of-each-level-of-binary-tree-in-alternate-order/
 */
public class AlternateLevelExtemeNodes {

	static void printExtemeNodesOnAlternateLevel(BinaryTree node){
		if(node == null)
			return;
		Queue<BinaryTree> q = new LinkedList<>();
		q.add(node);
		boolean flag = true;
		
		while(!q.isEmpty()){
			int nodeCount = q.size();
			int n = nodeCount;
			while(n-- > 0){
				BinaryTree temp = q.poll();
				if(temp.left != null)
					q.add(temp.left);
				
				if(temp.right != null)
					q.add(temp.right);
				
				if(flag && n == nodeCount - 1)
					System.out.println(temp.data);
				
				if(!flag && n == 0)
					System.out.println(temp.data);
			}
			
			flag = !flag;
		}
	}
	
	static BinaryTree createTree(){
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		root.right.left = new BinaryTree(6);
		root.right.right = new BinaryTree(7);
		root.left.left.left = new BinaryTree(8);
		root.left.left.right = new BinaryTree(9);
		root.left.right.left = new BinaryTree(10);
		root.left.right.right = new BinaryTree(11);
		root.right.left.left = new BinaryTree(12);
		root.right.left.right = new BinaryTree(13);
		root.right.right.left = new BinaryTree(14);
		root.right.right.right = new BinaryTree(15);
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = createTree();
		printExtemeNodesOnAlternateLevel(tree);
	}

}
