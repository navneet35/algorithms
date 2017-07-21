package com.algorithms.graph;

import java.util.Scanner;

public class BFSShortReach {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();//t = test cases
    
    for(int i = 1; i<=t; i++){
      int v = sc.nextInt();
      int e = sc.nextInt();
      DirectedFixEdgeWeightGraph g = new DirectedFixEdgeWeightGraph(v, e, 6);
      for(int j=1;j<=e;j++){
        int w = sc.nextInt();
        int x = sc.nextInt();
        g.addEdge(w, x);
        g.addEdge(x, w);
      }
      int s = sc.nextInt();
      Integer[] dist = g.shortestPath(s);
      for(int p = 1; p <= v; p++){
        if(p != s){
          if(dist[p] == Integer.MAX_VALUE)
            System.out.print(-1 + " ");
          else
            System.out.print(dist[p] + " ");
          
        }
      }
      
    }
  }

}
