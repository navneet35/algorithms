package com.algorithms.tree;

/* 
 * Check for Children Sum Property in a Binary Tree
 * Given a binary tree, write a function that returns true if the tree satisfies below property.
 * For every node, data value must be equal to sum of data values in left and right children. 
 * http://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 */
public class ConvertChildrenSumProperty {
	
	static boolean checkChildrenSumProperty(BinaryTree tree){
		if(tree == null)
			return true;
		else if(BinaryTree.isLeaf(tree))
			return true;
		int l = (tree.left != null) ? tree.left.data : 0;
		int r = (tree.right != null) ? tree.right.data : 0;
		
		return ((l + r == tree.data) && checkChildrenSumProperty(tree.left) && checkChildrenSumProperty(tree.right));		
	}
	
	static BinaryTree createTree(){
		BinaryTree root = new BinaryTree(10);
		root.left = new BinaryTree(8);
		root.left.left = new BinaryTree(3);
		root.left.right = new BinaryTree(5);
		root.right = new BinaryTree(2);
		root.right.left = new BinaryTree(2);
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = createTree();
		if(checkChildrenSumProperty(tree))
			System.out.println("Tree satisfies children sum property");
		else 
			System.out.println("Tree doesn't satisfies children sum property");
	}

}
