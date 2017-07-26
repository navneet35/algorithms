package com.algorithms.tree;

/* 
 * Convert an arbitrary Binary Tree to a tree that holds Children Sum Property
 * Given an arbitrary binary tree, convert it to a binary tree that holds Children Sum Property.
 * You can only increment data values in any node (You cannot change structure of tree and cannot decrement value of any node). 
 *  		   50
 *           /    \     
 *         /       \
 *       7          2
 *      / \         /\
 *    /     \      /   \
 *   3        5   1     30
 * Solution:
 *           50
 *         /    \     
 *       /       \
 *     19         31
 *    / \        /  \
 *  /     \     /    \
 * 14      5   1      30
 * http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/
 */
public class ChildrenSumProperty {
	
	static void convertChildrenSumProperty(BinaryTree tree){
		if(tree == null)
			return;
		else if(BinaryTree.isLeaf(tree))
			return;
		
		convertChildrenSumProperty(tree.left);
		convertChildrenSumProperty(tree.right);
		
		int l = (tree.left != null) ? tree.left.data : 0;
		int r = (tree.right != null) ? tree.right.data : 0;
		int diff = (l + r) - tree.data;
		if(diff < 0)
			tree.data = tree.data + diff;
		else if(diff > 0)
			incrementNodes(tree, -diff); // pass positive value
		
		return;
	}
	
	static void incrementNodes(BinaryTree tree, int diff){
		if(tree.left != null){
			tree.left.data = tree.left.data + diff;
			incrementNodes(tree.left, diff);
		}else if(tree.right != null){
			tree.right.data = tree.right.data + diff;
			incrementNodes(tree.right, diff);
		}
			
	}
	
	static boolean isSumProperty(BinaryTree node){
		if(node == null || BinaryTree.isLeaf(node))
			return true;
		int leftData = (node.left != null) ? node.left.data : 0;
		int rightData = (node.right != null) ? node.right.data : 0;
		return (node.data == (leftData + rightData) && isSumProperty(node.left) && isSumProperty(node.right));
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
		boolean result = isSumProperty(tree);
		System.out.println("Does Tree satisfies children sum property : " + result);
		if(!result){
			System.out.println("Converting tree to satisfy children sum property.");
			convertChildrenSumProperty(tree);
			System.out.println("Converted. Inorder traversal:");
			BinaryTreeUtil.inOrderTraversal(tree);
			
		}
	}

}
