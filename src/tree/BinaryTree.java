package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	int data;
	BinaryTree left, right;
	
	public BinaryTree() {}
	
	public BinaryTree(int data) {
		this.data = data;
	}
	
	public void inOrderTraversal(BinaryTree root){
		if(root == null)
			return;
		inOrderTraversal(root.left);
		System.out.print(root.data + ", ");
		inOrderTraversal(root.right);
	}
	
	public void preOrderTraversal(BinaryTree root){
		if(root == null)
			return;
		System.out.print(root.data + ", ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	public void postOrderTraversal(BinaryTree root){
		if(root == null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + ", ");
	}
	
	public void spiralOrderTraversal(BinaryTree root){
		if(root == null)
			return;
		Stack<BinaryTree> stack_1 = new Stack<BinaryTree>();
		Stack<BinaryTree> stack_2 = new Stack<BinaryTree>();
		stack_1.push(root);
		
		while(!stack_1.isEmpty() || !stack_2.isEmpty()){
			while(!stack_1.isEmpty()){
				BinaryTree node = stack_1.pop();
				System.out.print(node.data + ", ");
					if(node.right != null)
						stack_2.push(node.right);
					if(node.left != null)
						stack_2.push(node.left);
			}
			
			while(!stack_2.isEmpty()){
				BinaryTree node = stack_2.pop();
				System.out.print(node.data + ", ");
					if(node.left != null)
						stack_1.push(node.left);
					if(node.right != null)
						stack_1.push(node.right);
			}
			
		}
		
	}
	
	public void levelOrderTraversal(BinaryTree root){
		if(root == null)
			return;
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			BinaryTree node = queue.poll();
			System.out.print(node.data + ", ");
			if(node.left != null)
				queue.offer(node.left);
			if(node.right != null)
				queue.offer(node.right);
		}
	}
	
	private void printAllRootToLeafPathUtil(BinaryTree root, List<BinaryTree> path){
		if(root  == null)
			return;
		if(root.left == null && root.right == null){
			for(BinaryTree node : path)
				System.out.print(node.data + ", ");
			System.out.println(root.data);
			return;
		}
		
		path.add(root);
		printAllRootToLeafPathUtil(root.left, path);
		printAllRootToLeafPathUtil(root.right, path);
		path.remove(root);
	}
	
	public void printAllRootToLeafPath(BinaryTree root){
		if(root == null)
			return;
		printAllRootToLeafPathUtil(root, new ArrayList<BinaryTree>());
	}
}


