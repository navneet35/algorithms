package tree;
//http://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/

public class MaxDiffNodeAndAncestor {
	private static int maxDiff = Integer.MIN_VALUE;
	
	static int maxDiffBetweenNodeAndAncestor(BinaryTree node){
		if(node == null)
			return Integer.MAX_VALUE;
		
		if(BinaryTree.isLeaf(node))
			return node.data;
		
		int lMin = maxDiffBetweenNodeAndAncestor(node.left);
		int rMin = maxDiffBetweenNodeAndAncestor(node.right);
		int diff = node.data - Math.min(lMin, rMin);
		if(diff > maxDiff)
			maxDiff = diff;
		
		return Math.min(lMin, rMin);
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
		BinaryTree root = createTree();
		maxDiffBetweenNodeAndAncestor(root);
		System.out.println(maxDiff);
	}

}
