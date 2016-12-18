package tree;

public class RootToLeafPathWithASequence {
	static boolean isLeaf(BinaryTree root){
		return root.left == null && root.right == null;
	}
	
	static boolean checkPath(BinaryTree root, int i, String str){
		if(root == null)
			return false;
		if(root != null && isLeaf(root) && i == str.length()-1 && root.data == Integer.parseInt(str.charAt(i)+""))
			return true;
		if(i < str.length() && root.data == Integer.parseInt(str.charAt(i)+"")){
			if(checkPath(root.left, i+1, str))
				return true;
			if(checkPath(root.right, i+1, str))
				return true;
		}
		return false;
	}
	
	public static BinaryTree createTree(){
		BinaryTree t = new BinaryTree(2);
		t.left = new BinaryTree(8);
		t.left.left = new BinaryTree(4);
		t.left.right = new BinaryTree(5);
		t.left.right.left = new BinaryTree(9);
		t.left.right.right = new BinaryTree(7);
		t.right = new BinaryTree(3);
		return t;
	}
	
	
	public static void main(String[] args) {
		BinaryTree tree = createTree();
		System.out.println(checkPath(tree, 0, "2857"));
	}
}
