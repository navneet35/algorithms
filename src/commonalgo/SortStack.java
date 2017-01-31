package commonalgo;

import java.util.Stack;

public class SortStack {
	
	private void sortedInsert(Stack<Integer> stack, Integer element){
		if(stack.isEmpty() || element > stack.peek())
			stack.push(element);
		else{
			Integer elm = stack.pop();
			sortedInsert(stack, element);
			stack.push(elm);
		}
	}
	
	private void sort(Stack<Integer> stack){
		if(!stack.isEmpty()){
			Integer top = stack.pop();
			sort(stack);
			sortedInsert(stack, top);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(30);
		st.push(-5);
		st.push(18);
		st.push(14);
		st.push(-3);
		System.out.println("Original Stack:");
		for(int i=st.size()-1;i>=0;i--){
			System.out.println("|---|");
			System.out.println("| "+ st.get(i) + " |");
		}
		System.out.println("|---|");
		SortStack obj = new SortStack();
		obj.sort(st);
		System.out.println("Sorted Stack:");
		for(int i=st.size()-1;i>=0;i--){
			System.out.println("|---|");
			System.out.println("| "+ st.get(i) + " |");
		}
		System.out.println("|---|");
		
	}

}
