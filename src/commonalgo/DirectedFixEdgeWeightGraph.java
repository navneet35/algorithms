package commonalgo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class DirectedFixEdgeWeightGraph{
  private int V;
  private int E;
  private int fixedEdgeWeight;
  private List<Integer>[] adjList;
  
  public DirectedFixEdgeWeightGraph(){}

  public DirectedFixEdgeWeightGraph(int v, int e, int fixedEdgeWeight){
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
  
  public void bfs(int s){
	  Boolean[] visited = new Boolean[V+1];
	  Queue<Integer> queue = new LinkedList<Integer>();
	  
	  for(int i = 1; i<= V; i++)
		visited[i] = false;
	  
	  queue.offer(s);

	  while(!queue.isEmpty()){
		  Integer node = queue.poll();
		  System.out.println(node);
		  visited[node] = true;
		  for(Integer neighbour : adjList[node]){
			  if(!visited[neighbour]){
				queue.offer(neighbour);
				visited[neighbour] = true;
			  }
		  }
	  }
	  
  }
  
  public void dfs(int s){
	  Boolean[] visited = new Boolean[V+1];
	  for(int i=1; i<=V; i++)
		  visited[i] = false;
	  
	  dfsInGraph(s, visited);
  }
  
  private void dfsInGraph(int s, Boolean[] visited){
	  System.out.println(s);
	  visited[s] = true;
	  for(Integer neighbour : adjList[s]){
		  if(!visited[neighbour]){
			  dfsInGraph(neighbour, visited);
		  }
	  }
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
