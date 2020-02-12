package com.algorithms.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author - navsinn
 */
public class Graph<T> {
    private class Vertex {
        private T vertex;
    }
    private List<Vertex> vertices;
    private int v;
    private LinkedList<Vertex> adj[];

    public Graph(int noOfVertices) {
        v = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for(int i=0; i<noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }
}
