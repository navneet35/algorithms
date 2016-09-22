package commonalgo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFSShortReach {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int i = 1; i<=t; i++){
      int v = sc.nextInt();
      int e = sc.nextInt();
      Graph g = new Graph(v, e, 6);
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

class Graph{
  private int V;
  private int E;
  private int fixedEdgeWeight;
  private List<Integer>[] adjList;
  
  public Graph(){}

  public Graph(int v, int e, int fixedEdgeWeight){
    this.V = v;
    this.E = e;
    this.fixedEdgeWeight = fixedEdgeWeight;
    this.adjList = (List<Integer>[]) new List[V+1];
    for(int i=1;i<=v;i++){
      adjList[i] = new ArrayList<>();
    }
  }
  
  public void addEdge(int v, int w){
    adjList[v].add(w);
  }
  
  public Integer[] shortestPath(int s){
    Boolean[] visited = new Boolean[V+1];
    Integer[] dist = new Integer[V+1];
    Queue<Integer> queue = new LinkedList<Integer>();
    
    for(int i=1; i <= V; i++){
      visited[i] = false;
      dist[i] = Integer.MAX_VALUE;
    }
    
    queue.offer(s);
    dist[s] = 0;
    
    while(!queue.isEmpty()){
      Integer node = queue.poll();
      visited[node] = true;
      
      for(Integer v : adjList[node]){
        if(!visited[v]){
          queue.offer(v);
        }
        
        if(!visited[v] && dist[node] != Integer.MAX_VALUE && dist[v] > dist[node] + fixedEdgeWeight)
          dist[v] = dist[node] + fixedEdgeWeight;
          
      }
      
    }
    
    return dist;
  }
  
  
}
