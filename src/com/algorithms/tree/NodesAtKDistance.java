package com.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class NodesAtKDistance {

	List<BinaryTree> path = new ArrayList<BinaryTree>();
	
	void printNodesAtKDistanceBelow(BinaryTree root, int k){
		if(root == null)
			return;
		if(k == 0)
			System.out.print(root.data + " ");
		
		printNodesAtKDistanceBelow(root.left, k-1);
		printNodesAtKDistanceBelow(root.right, k-1);
	}
	
	boolean findPath(BinaryTree t, BinaryTree target){
		if(t == null)
			return false;
		if(t == target || findPath(t.left, target) || findPath(t.right, target)){
			path.add(t);
			System.out.print(t.data + "->");
			return true;
		}
		return false;
		
	}
	void printNodesAtKDistance(BinaryTree root, BinaryTree target, int k){
		findPath(root, target);
		System.out.println();
		printNodesAtKDistanceBelow(path.get(0), k);
		int index = Math.min(path.size()-1, k);
		for(int i=1; i<=index; i++){
			BinaryTree node = path.get(i);
			if(k-i == 0)
				System.out.print(node.data + " ");
			else if(node.left == path.get(i-1))
				printNodesAtKDistanceBelow(node.right, k-i-1);
			else if(node.right == path.get(i-1))
				printNodesAtKDistanceBelow(node.left, k-i-1);
		}
	}
	
	public static BinaryTree createTree(){
		BinaryTree t = new BinaryTree(20);
		t.left = new BinaryTree(8);
		t.left.left = new BinaryTree(4);
		t.left.right = new BinaryTree(12);
		t.left.right.left = new BinaryTree(10);
		t.left.right.right = new BinaryTree(14);
		t.right = new BinaryTree(22);
		return t;
	}
	
	public static void main(String[] args) {
		BinaryTree t = createTree();
		NodesAtKDistance nk = new NodesAtKDistance();
		BinaryTree target = t.right;
		nk.printNodesAtKDistance(t, target, 4);
	}

}
