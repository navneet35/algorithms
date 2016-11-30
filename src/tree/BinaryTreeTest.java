package tree;

public class BinaryTreeTest {
  
    public BinaryTree createTree(BinaryTree tree){
		tree = new BinaryTree(1);
		tree.left = new BinaryTree(2);
		tree.right = new BinaryTree(3);
		tree.left.left = new BinaryTree(4);
		tree.left.right = new BinaryTree(5);
		tree.right.left = new BinaryTree(6);
		tree.right.right = new BinaryTree(7);
		tree.left.left.left = new BinaryTree(8);
		tree.right.right.right = new BinaryTree(9);
		tree.left.left.left.left = new BinaryTree(10);
		return tree;
	}
	
	public BinaryTree createTreeForSymmetricCheck(BinaryTree tree){
      tree = new BinaryTree(1);
      tree.left = new BinaryTree(2);
      tree.right = new BinaryTree(2);
      tree.left.left = new BinaryTree(3);
      tree.left.right = new BinaryTree(4);
      tree.right.left = new BinaryTree(4);
      tree.right.right = new BinaryTree(3);
      tree.right.right.right = new BinaryTree(5);
      tree.left.left.left = new BinaryTree(5);
      return tree;
    }

	public void treeTraversals(BinaryTree tree){
	    BinaryTreeUtil btu = new BinaryTreeUtil();
		System.out.println("Inorder Traversal");
		btu.inOrderTraversal(tree);
		System.out.println();
		System.out.println("PreOrder Traversal");
		btu.preOrderTraversal(tree);
		System.out.println();
		System.out.println("PostOrder Traversal");
		btu.postOrderTraversal(tree);
		System.out.println();
		System.out.println("LevelOrder Traversal");
		btu.levelOrderTraversal(tree);
		System.out.println();
		System.out.println("SpiralOrder Traversal");
		btu.spiralOrderTraversal(tree);
		System.out.println();
		System.out.println("Print all Root to Leaf Paths");
		btu.printAllRootToLeafPath(tree);
		System.out.println();
        System.out.println("Is BST");
        if(btu.isBST(tree)){
          System.out.println("Tree is BST");
        }else{
          System.out.println("Tree is NOT a BST");
        }
	}
	
	
	public static void main(String[] args) {
		BinaryTreeTest treeTest = new BinaryTreeTest();
		BinaryTreeUtil btUtil = new BinaryTreeUtil();
		
		BinaryTree tree = null;
		System.out.println("Create tree");
		tree = treeTest.createTree(tree);
		treeTest.treeTraversals(tree);
		
		BinaryTree symmetricTree = null;
        System.out.println("Create tree");
        symmetricTree = treeTest.createTreeForSymmetricCheck(symmetricTree);
        System.out.println(btUtil.isBinaryTreeSymmetric(tree));
        
        btUtil.rightViewOfBinaryTree(tree);
        
        btUtil.printBinaryTreeVerticalOrder(tree);
        
        btUtil.topViewOfBinaryTree(tree);
        
        btUtil.bottomViewOfBinaryTree(tree);
		
	}
	
}
