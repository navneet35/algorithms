package tree;

public class BinaryTreeTest {
	BinaryTree tree;
	
	public void createTree(){
		tree = new BinaryTree(1);
		tree.left = new BinaryTree(2);
		tree.right = new BinaryTree(3);
		tree.left.left = new BinaryTree(4);
		tree.left.right = new BinaryTree(5);
		tree.right.left = new BinaryTree(6);
		tree.right.right = new BinaryTree(7);
		tree.left.left.left = new BinaryTree(8);
		tree.right.right.right = new BinaryTree(9);
	}

	public void treeTraversals(){
		System.out.println("Inorder Traversal");
		tree.inOrderTraversal(tree);
		System.out.println();
		System.out.println("PreOrder Traversal");
		tree.preOrderTraversal(tree);
		System.out.println();
		System.out.println("PostOrder Traversal");
		tree.postOrderTraversal(tree);
		System.out.println();
		System.out.println("LevelOrder Traversal");
		tree.levelOrderTraversal(tree);
		System.out.println();
		System.out.println("SpiralOrder Traversal");
		tree.spiralOrderTraversal(tree);
		System.out.println();
		System.out.println("Print all Root to Leaf Paths");
		tree.printAllRootToLeafPath(tree);
	}
	
	public static void main(String[] args) {
		BinaryTreeTest treeTest = new BinaryTreeTest();
		System.out.println("Create tree");
		treeTest.createTree();
		treeTest.treeTraversals();
	}

}
