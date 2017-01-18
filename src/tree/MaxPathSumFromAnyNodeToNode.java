/*
 * http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 */
package tree;

public class MaxPathSumFromAnyNodeToNode {

	private int maxSum = Integer.MIN_VALUE;
	
	private int maxSumPath(BinaryTree node){
		if(node == null)
			return 0;
		
		int lMax = maxSumPath(node.left);
		int rMax = maxSumPath(node.right);
		int max = Math.max((Math.max(lMax, rMax) + node.data), node.data);
		maxSum = Math.max(Math.max(max, lMax + rMax + node.data), maxSum);
		return max;
	}
	
	static BinaryTree createTree(){
		BinaryTree root = new BinaryTree(10);
		root.left = new BinaryTree(2);
		root.left.left = new BinaryTree(20);
		root.left.right = new BinaryTree(1);
		root.right = new BinaryTree(10);
		root.right.right = new BinaryTree(-25);
		root.right.right.left = new BinaryTree(3);
		root.right.right.right = new BinaryTree(4);
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTree root = createTree();
		MaxPathSumFromAnyNodeToNode obj = new MaxPathSumFromAnyNodeToNode();
		obj.maxSumPath(root);
		System.out.println(obj.maxSum);
	}

}
