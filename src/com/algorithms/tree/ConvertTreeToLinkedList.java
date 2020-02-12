package com.algorithms.tree;

/**
 * @author - navsinn
 * @date - Dec 22, 2018
 */
/**
 * https://www.geeksforgeeks.org/flatten-a-binary-tree-into-linked-list/
 * */
public class ConvertTreeToLinkedList {

    BinaryTree head = null;
    public void flatten(BinaryTree root) {
        if(root == null)
            return;
        if(head == null){
            head = root;
        }

        if(root.left != null) {
            root.right = root.left;
            flatten(root.left);
        }
        if(root.right != null) {
            flatten(root.right);
        }

    }
}
