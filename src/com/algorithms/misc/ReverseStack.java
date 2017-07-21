package com.algorithms.misc;

import java.util.Stack;

public class ReverseStack {
	
	private void insertAtBottom(Stack<Integer> stack, Integer element){
		if(stack.isEmpty())
			stack.push(element);
		else{
			Integer elm = stack.pop();
			insertAtBottom(stack, element);
			stack.push(elm);
		}
	}
	
	private void reverse(Stack<Integer> stack){
		if(!stack.isEmpty()){
			Integer top = stack.pop();
			reverse(stack);
			insertAtBottom(stack, top);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(4);
		st.push(3);
		st.push(2);
		st.push(1);
		System.out.println("Original Stack:");
		for(int i=0;i<st.size();i++){
			System.out.println("|---|");
			System.out.println("| "+ st.get(i) + " |");
		}
		System.out.println("|---|");
		ReverseStack obj = new ReverseStack();
		obj.reverse(st);
		System.out.println("Reverse Stack:");
		for(int i=0;i<st.size();i++){
			System.out.println("|---|");
			System.out.println("| "+ st.get(i) + " |");
		}
		System.out.println("|---|");
		
	}

}
