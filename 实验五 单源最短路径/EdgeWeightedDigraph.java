package sssp;

import java.util.LinkedList;




public class EdgeWeightedDigraph {
	private final int V;
	private int E;
	private LinkedList<DirectedEdge>[] adj;
	
	public EdgeWeightedDigraph(int v) {
		V = v;
		E = 0;
		adj = new LinkedList[V];
		for(int i =0;i<v;i++){
			adj[i] = new LinkedList<DirectedEdge>();
		}
	}
	public int V(){
		return V;
	}
	public int E(){
		return E;
	}
	public void addEdge(DirectedEdge e){
		adj[e.from()].add(e);
		E++;
	}
	public Iterable<DirectedEdge> adj(int v){
		return adj[v];
	}
	public Iterable<DirectedEdge> edges(){
		LinkedList<DirectedEdge> l = new LinkedList<DirectedEdge>();
		for(int v =0;v<V;v++){
			for(DirectedEdge e :adj[v]){
				l.add(e);
			}
		}
		return l;
	}
}
