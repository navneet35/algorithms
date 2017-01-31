package tree;

public class BinaryTree {
	int data;
	BinaryTree left, right;
	
	public BinaryTree() {}
	
	public BinaryTree(int data) {
		this.data = data;
	}
	
	public static boolean isLeaf(BinaryTree node){
		return (node != null && node.left == null && node.right == null);
	}
	
}


