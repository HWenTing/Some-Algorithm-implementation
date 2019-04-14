package MaxFlow;

import java.util.*; 
import java.lang.*; 
import java.io.*; 
import java.util.LinkedList;

import sssp.DirectedEdge;
import sssp.EdgeWeightedDigraph;
  
class EdmondsKarp 
{ 
   	private int V;
   	private double rGraph[][];
   	
   	public EdmondsKarp(EdgeWeightedDigraph G){
   		V = G.V();
   		rGraph = new double[V][V];
   		for(int v =0 ;v<V;v++){
   			for(DirectedEdge e :G.adj(v)){
   				rGraph[e.from()][e.to()] = e.weight();
   			}
   		}
   		
   	}

    boolean bfs(int s, int t, int parent[]) 
    { 
        boolean visited[] = new boolean[V]; 
        for(int i=0; i<V; ++i) 
            visited[i]=false; 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        queue.add(s); 
        visited[s] = true; 
        parent[s]=-1; 
        while (queue.size()!=0) { 
            int u = queue.poll(); 
            for (int v=0; v<V; v++){ 
                if (visited[v]==false && rGraph[u][v] > 0) { 
                    queue.add(v); 
                    parent[v] = u; 
                    visited[v] = true; 
                } 
            } 
        } 
        return (visited[t] == true); 
    } 
  
    // Returns tne maximum flow from s to t in the given graph 
    int edmondsKarp(int s, int t) 
    { 
        int u, v; 
        int parent[] = new int[V]; 
  
        int max_flow = 0;  // There is no flow initially 
        while (bfs(s, t, parent)) { 
            double path_flow = Double.POSITIVE_INFINITY; 
            for (v=t; v!=s; v=parent[v]) { 
                u = parent[v]; 
                if(path_flow>rGraph[u][v]){
                	path_flow = rGraph[u][v];
                }
            } 
            for (v=t; v != s; v=parent[v]) { 
                u = parent[v]; 
                rGraph[u][v] -= path_flow; 
                rGraph[v][u] += path_flow; 
            } 
            max_flow += path_flow; 
        } 
        return max_flow; 
    } 
  
    // Driver program to test above functions 
    public static void main (String[] args) throws java.lang.Exception 
    { 
    	EdgeWeightedDigraph G = new EdgeWeightedDigraph(6);
		G.addEdge(new DirectedEdge(0, 1, 2));
		G.addEdge(new DirectedEdge(0, 2, 3));
		G.addEdge(new DirectedEdge(1, 3, 3));
		G.addEdge(new DirectedEdge(1, 4, 1));
		G.addEdge(new DirectedEdge(2, 3, 1));
		G.addEdge(new DirectedEdge(2, 4, 1));
		G.addEdge(new DirectedEdge(4, 5, 3));
		G.addEdge(new DirectedEdge(3, 5, 2));
		EdmondsKarp F = new EdmondsKarp(G);
  
        System.out.println("The maximum possible flow is " + 
                           F.edmondsKarp(0, 5)); 
  
    } 
} 
