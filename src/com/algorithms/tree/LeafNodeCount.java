package com.algorithms.tree;

public class LeafNodeCount {
	
	static int countLeafNodes(BinaryTree tree){
		if(tree == null)
			return 0;
		else if(BinaryTree.isLeaf(tree))
			return 1;
		return countLeafNodes(tree.left) + countLeafNodes(tree.right);
	}
	
	static BinaryTree createTree(){
		BinaryTree root = new BinaryTree(8);
		root.left = new BinaryTree(3);
		root.left.left = new BinaryTree(1);
		root.left.right = new BinaryTree(6);
		root.left.right.left = new BinaryTree(4);
		root.left.right.right = new BinaryTree(7);
		root.right = new BinaryTree(10);
		root.right.right = new BinaryTree(14);
		root.right.right.left = new BinaryTree(13);
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = createTree();
		System.out.println(countLeafNodes(tree));

	}

}
