package com.algorithms.tree;

import java.util.HashMap;
import java.util.Map;


/**
 * @author navneet
 * @since 20 July 2017
 * 
 * Connect nodes at same level using constant extra space
 * Write a function to connect all the adjacent nodes at the same level in a binary tree. Structure of the given Binary Tree node is like following.
 *
 * struct node {
 *  int data;
 *  struct node* left;
 *  struct node* right;
 *  struct node* nextRight;
 * }
 * 
 * http://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
 */

public class ConnectNodeOnSameLevel {
	private static class BTree{
		int data;
		BTree left, right, nextRight;
		BTree(int data){
			this.data = data;
		}
	}
	
	static BTree getNextRight(BTree node){
		if(node == null)
			return null;
		BTree temp = node;
		temp = temp.nextRight;
		while(node != null){
			if(temp.left != null)
				return temp.left;
			else if(temp.right != null)
				return temp.right;
			temp = temp.nextRight;
		}
		
		return null;
	}
	
	static void connectIterative(BTree root){
		if(root == null)
			return;
		root.nextRight = null;
		while(root != null){
			BTree temp = root;
			while(temp != null){
				if(temp.left != null){
					if(temp.right != null)
						temp.left.nextRight = temp.right;
					else 
						temp.left.nextRight = getNextRight(temp);
				}
				if(temp.right != null)
					temp.right.nextRight = getNextRight(temp);
				
				temp = temp.nextRight;
			}
			
			if(root.left != null)
				root = root.left;
			else if(root.right != null)
				root = root.right;
			else 
				root = root.nextRight;
		}
		
	}
	
	static BTree createTree(){
		BTree root = new BTree(10);
		root.left = new BTree(8);
		root.left.left = new BTree(3);
		root.left.right = new BTree(5);
		root.right = new BTree(2);
		root.right.left = new BTree(2);
		return root;
	}
	
	public static void main(String[] args) {
		BTree tree = createTree();
//		connectIterative(tree);
		String s = " asd";
		Character c= s.charAt(0);
		Map<Character, Integer> map = new HashMap<>();
		if(c == ' '){
			System.out.println("hi");
		}
	}
}
