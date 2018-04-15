package com.algorithms.linkedlist;

public class SinglyLinkedList<E> {
	private SingleNode<E> first;
	private SingleNode<E> last;
	private int size;
	
	/**
	 * This method prints the content of the linked list.
	 * */
	public void printList(){
		if(size == 0){
			System.out.println("No nodes in the list");
			return;
		}
		
		for(SingleNode<E> temp = first; temp != null; temp = temp.getNext())
			System.out.print(temp.getData() + " -> ");
		System.out.println();
	}
	
	/**
	 * This method adds the record at the end of the linked list.
	 * @param e record to be added
	 * */
	public void add(E e){
		SingleNode<E> l = last;
		SingleNode<E> newNode = new SingleNode<E>(e, null);
		if(l == null)
			first = last = newNode;
		else{
			l.setNext(newNode);
			last = newNode;
		}
		size++;
		
	}
	
	/**
	 * This method adds the record at the start of the linked list.
	 * @param e record to be added
	 * */
	public void addFirst(E e){
		SingleNode<E> f = first;
		SingleNode<E> newNode = new SingleNode<E>(e, null);
		if(f == null)
			first = last = newNode;
		else{
			newNode.setNext(f);
			first = newNode;
		}
		
		size++;
	}
	
	public void append(E e){
		add(e);
	}
	
	/**
	 * Delete a node present in the list.
	 * If not present then return false else return true.
	 */
	public boolean deleteNode(E e){
		SingleNode<E> prev = null, temp = first;		
		
		if(temp.getData() == e){
			first = first.getNext();
			return true;
		}
		
		for(;temp != null && !temp.equalsData(e); temp = temp.getNext()){
			prev = temp;
		}
		
		if(prev == null){
			System.out.println("Node not found");
			return false;
		}
		
		prev.setNext(prev.getNext().getNext());
		return true;
	}

	/**
	 * This method removes the record at a specific position in the linked list.
	 * @param position position on which the records present is to be deleted
	 * */	
	public boolean deleteNodeAtPosition(Integer position){
		if(position > size)
			return false;
		if(position == 1){
			first = first.getNext();
			return true;
		}
		
		SingleNode<E> temp = first;
		for(int i=1;i<position-1; i++, temp = temp.getNext());
		temp.setNext(temp.getNext().getNext());
		return true;
	}
	
	/**
	 * This method reverse the linked list.
	 * */
	public void reverse(){
		if(first == null){
			System.out.println("No element in the list");
			return;
		}
		else if(first == last){
			System.out.println("Only one element in the list. Cannot be reversed");
			return;
		}
		
		SingleNode<E> cur = first, prev, next;
		prev = next = null;
		
		while(cur != null){
			next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		
		last = first;
		first = prev;
	}
	
	/**
	 * This method checks if there is any loop in the linked list.
	 * */
	public boolean ifContainsLoop(){
		if(this.isEmpty())
			return false;
		
		//Check using Floyd's Cycle Finding Algo
		SingleNode<E> slow = first, fast = first;
		while(slow != null && fast != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			
			if(slow == fast)
				return true;
		}
		return false;
	}
	
	/*
	 * Reverse a linked list in a group of size k
	 * */
	public static SingleNode reverse(SingleNode node, int k){
		SingleNode prev = null, cur = node, next = null;
		if(node == null)
			return null;
		
		for(int i = 0; i < k && cur != null; i++){
			next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		
		if(next != null)
			node.setNext(reverse(next, k));
		
		return prev;
	}
	
	/**
	 * This method check if the linked list is empty.
	 * @return true if list is empty else false
	 * */
	public boolean isEmpty(){
		return first == null;
	}
	
	/**
	 * This method swaps two records in the linked list
	 * @param e1 first record
	 * @param e2 second record
	 * */
	public boolean swapNodes(E e1, E e2){
		return false;
	}
	
	/**
	 * This method returns the first record in the linked list
	 * @return first record
	 * */
	public SingleNode<E> getFirst() {
		return first;
	}
	
	public void setFirst(SingleNode<E> first) {
		this.first = first;
	}

	public SingleNode<E> getLast() {
		return last;
	}

	public void setLast(SingleNode<E> last) {
		this.last = last;
	}
	
}
