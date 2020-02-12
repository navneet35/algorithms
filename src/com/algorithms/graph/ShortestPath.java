package com.algorithms.graph;

import java.util.*;

/**
 * @author - navsinn
 */
public class ShortestPath {
    class Vertex implements Comparable<Vertex>{
        int node;
        int dist;
        Vertex(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }

    public void dijkstra(int graph[][], int src) {
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> nodeDistFromSrc = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int i=0; i<graph[0].length; i++) {
            nodeDistFromSrc.put(i, Integer.MAX_VALUE);
        }

        parent.put(src, null);
        queue.add(new Vertex(src, 0));
        nodeDistFromSrc.put(src, 0);

        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            visited.add(v);
            for(int i=0;i<graph[v].length; i++) {
                if(graph[v][i] > 0 && !visited.contains(i) && nodeDistFromSrc.get(v) + graph[v][i] < nodeDistFromSrc.get(i)) {
                    queue.add(i);
                    nodeDistFromSrc.put(i, nodeDistFromSrc.get(v) + graph[v][i]);
                    parent.put(i, v);
                }
            }
        }

        for(Integer key : nodeDistFromSrc.keySet()) {
            System.out.println("Node:" + key + ", Dist:" + nodeDistFromSrc.get(key));
        }
    }
}
