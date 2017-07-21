package com.algorithms.graph;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {
	
	public void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack, DirectedFixEdgeWeightGraph g ){
		visited[v] = true;
		Iterator it = g.getAdjList()[v].iterator();
		while(it.hasNext()){
			Integer i = (Integer) it.next();
			if(!visited[i])
				topologicalSortUtil(i, visited, stack, g);
		}
		
		stack.push(v);
	}
	
	public void topologicalSort(DirectedFixEdgeWeightGraph g){
		boolean[] visited = new boolean[g.getV() + 1];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=1; i< g.getV(); i++)
			visited[i] = false;
		
		for(int i=1; i<= g.getV(); i++){
			if(!visited[i]){
				topologicalSortUtil(i, visited, stack, g);
			}
		}
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

	public static void main(String[] args) {
		DirectedFixEdgeWeightGraph graph = new DirectedFixEdgeWeightGraph(6, 6, 6);
		graph.addEdge(6, 3);
		graph.addEdge(6, 1);
		graph.addEdge(5, 2);
		graph.addEdge(5, 1);
		graph.addEdge(3, 4);
		graph.addEdge(4, 2);
		TopologicalSort ts = new TopologicalSort();
		ts.topologicalSort(graph);
	}

}
