package com.algorithms.graph;


public class DFSInGraph {

	public static void main(String[] args) {
		DirectedFixEdgeWeightGraph g = new DirectedFixEdgeWeightGraph(4, 4, 6);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 4);
 
        System.out.println("Following is Depth First Traversal (starting from vertex 2)");
        g.dfs(3);
	}

}

