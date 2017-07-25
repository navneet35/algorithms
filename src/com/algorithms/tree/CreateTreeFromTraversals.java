package com.algorithms.tree;

public class CreateTreeFromTraversals {
	static int i = 0;

	static int indexOf(String str, char c, int fromIndex, int toIndex){
		if(str == null || str.isEmpty())
			return -1;
		
		for(int i = fromIndex; i < toIndex; i++){
			if(str.charAt(i) == c)
				return i;
		}
		return -1;
	}
	
	static BinaryTree fromPreorderAndInorder(String pre, String in, int l, int h){
		if(l > h)
			return null;
		
		char ch = pre.charAt(i++);
		BinaryTree node = new BinaryTree(Character.getNumericValue(ch));
		
		if(l == h)
			return node;
		int index = indexOf(in, ch, l, h);
		if(index == -1)
			return null;
		node.left = fromPreorderAndInorder(pre, in, l, index-1);
		node.right = fromPreorderAndInorder(pre, in, index+1, h);
		return node;
	}	
	
	public static void main(String[] args) {
		String pre = "12453678";
		String in = "42513768";
		BinaryTree root = fromPreorderAndInorder(pre, in, 0, pre.length() - 1);
		BinaryTreeUtil.inOrderTraversal(root);
	}

}
