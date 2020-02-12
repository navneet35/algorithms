package com.algorithms.graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author - navsinn
 */
public class UndirectedGraph {
    private int V;
    private LinkedList<Integer> adj[];

    public UndirectedGraph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public boolean isContainsCyle() {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        for (int i = 0; i < V; i++) {
            if (visited[i]) {
                if (isContainsCycleUtil(i, -1, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean isContainsCycleUtil(int vertex, int parent, boolean[] visited) {
        visited[vertex] = true;

        for(int neighbour : adj[vertex]) {
            if(!visited[neighbour]) {
                if(isContainsCycleUtil(neighbour, vertex, visited)){
                    return true;
                }
            } else if(neighbour != parent) {
                return true;
            }
        }
        return false;
    }
}
