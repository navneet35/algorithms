package com.algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTreeUtil {
  class MaxLevel{
    int maxLevel = -1;
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
  
  private boolean isBinaryTreeSymmetricUtil(BinaryTree left, BinaryTree right){
    if(left == null && right == null){
      return true;
    }
    
    if(left!=null && right!=null && left.data == right.data 
        && isBinaryTreeSymmetricUtil(left.left, right.right) 
        && isBinaryTreeSymmetricUtil(left.right, right.left))
      return true;
    
    return false;
  }
  
  public boolean isBinaryTreeSymmetric(BinaryTree root){
    System.out.println("IsBinaryTreeSymmetric");
    if(root == null)
      return true;
    return isBinaryTreeSymmetricUtil(root, root);
  }
  
  private void printRightViewBinaryTreeUtil(BinaryTree root, int level, MaxLevel maxLevel){
    if(root == null)
      return;
    if(maxLevel.maxLevel < level){
      System.out.print(root.data + ", ");
      maxLevel.maxLevel = level;
    }
    
    printRightViewBinaryTreeUtil(root.right, level+1, maxLevel);
    printRightViewBinaryTreeUtil(root.left, level+1, maxLevel);
    
  }
  
  public void rightViewOfBinaryTree(BinaryTree root){
    System.out.println("Print right view of binary tree");
    if(root == null)
      return;
    printRightViewBinaryTreeUtil(root, 0, new MaxLevel());
  }
  
  /*   
   *       1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9 
               
              
  The output of print this tree vertically will be:
  4
  2
  1 5 6
  3 8
  7
  9
  hd = horizontal distance from root. hd(root) = 0, hd(root.left) = -1, hd(root.right) = 1
   * */
  public void printBinaryTreeVerticalOrderUtil(BinaryTree root, int hd, Map<Integer, ArrayList<BinaryTree>> hdNodeMap){
    if(root == null)
      return;
    if(!hdNodeMap.containsKey(hd)){
      hdNodeMap.put(hd, new ArrayList<BinaryTree>());
    }
    
    hdNodeMap.get(hd).add(root);
    printBinaryTreeVerticalOrderUtil(root.left, hd-1, hdNodeMap);
    printBinaryTreeVerticalOrderUtil(root.right, hd+1, hdNodeMap);
    
  }

  public void printBinaryTreeVerticalOrder(BinaryTree root){
    Map<Integer, ArrayList<BinaryTree>> hdNodeMap = new TreeMap<Integer, ArrayList<BinaryTree>>();
    printBinaryTreeVerticalOrderUtil(root, 0, hdNodeMap);
    System.out.println("Vertical order of tree is : ");
    
    for(Integer key : hdNodeMap.keySet()){
      System.out.println("For distance : " + key);
      for(BinaryTree node : hdNodeMap.get(key)){
        System.out.print(node.data + ", ");
      }
      System.out.println();
    }
  }
  
  private void printTopViewBinaryTreeUtil(BinaryTree root, int hd, Map<Integer, BinaryTree> hdNodeMap){
    if(root == null)
      return;
    
    if(!hdNodeMap.containsKey(hd))
      hdNodeMap.put(hd, root);
    
    printTopViewBinaryTreeUtil(root.right, hd+1, hdNodeMap);
    printTopViewBinaryTreeUtil(root.left, hd-1, hdNodeMap);
    
  }
  
  public void topViewOfBinaryTree(BinaryTree root){
    System.out.println("Print top view of binary tree");
    if(root == null)
      return;
    Map<Integer, BinaryTree> hdNodeMap = new TreeMap<Integer, BinaryTree>();
    printTopViewBinaryTreeUtil(root, 0, hdNodeMap);
    
    for(Entry<Integer, BinaryTree> hdNode : hdNodeMap.entrySet()){
      System.out.print(String.format("For hd : %s node : %s", hdNode.getKey(), hdNode.getValue().data));
      System.out.println();
    }
    
  }
  
  private void printBottomViewBinaryTreeUtil(BinaryTree root, int hd, Map<Integer, BinaryTree> hdNodeMap){
    if(root == null)
      return;
    
    hdNodeMap.put(hd, root);
    printBottomViewBinaryTreeUtil(root.right, hd+1, hdNodeMap);
    printBottomViewBinaryTreeUtil(root.left, hd-1, hdNodeMap);
    
  }
  
  public void bottomViewOfBinaryTree(BinaryTree root){
    System.out.println("Print BOTTOM view of binary tree");
    if(root == null)
      return;
    Map<Integer, BinaryTree> hdNodeMap = new TreeMap<Integer, BinaryTree>();
    printBottomViewBinaryTreeUtil(root, 0, hdNodeMap);
    
    for(Entry<Integer, BinaryTree> hdNode : hdNodeMap.entrySet()){
      System.out.print(String.format("For hd : %s node : %s", hdNode.getKey(), hdNode.getValue().data));
      System.out.println();
    }
    
  }
  
  private boolean isBSTUtil(BinaryTree root, BinaryTree prev){
    if (root != null)
    {
        if (!isBSTUtil(root.left, prev))
            return false;

//        System.out.print(root.data + "->");
        if (prev != null && root.data <= prev.data )
            return false;
        prev = root;
        return isBSTUtil(root.right, prev);
    }
    return true;
    
  }
  
  public boolean isBST(BinaryTree root){
    if(root == null) 
      return true;
    
    BinaryTree prev = null;
    return isBSTUtil(root, prev);
  }
    
}
