package com.algorithms.linkedlist;

public class SingleNode<E> {
	private E data;
	private SingleNode<E> next;
	
	public SingleNode(E data, SingleNode<E> next) {
		super();
		this.data = data;
		this.next = next;
	}

	public E getData() {
		return data;
	}
	
	public void setData(E data) {
		this.data = data;
	}

	public SingleNode<E> getNext() {
		return next;
	}

	public void setNext(SingleNode<E> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
	public boolean equalsData(E e){
		return this.data == e;
	}
	
}
