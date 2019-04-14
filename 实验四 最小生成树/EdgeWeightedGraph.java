package spanTree;

import java.util.LinkedList;

public class EdgeWeightedGraph {

	private final int V;
	private int E;
	private LinkedList<Edge>[] adj;
	
	public EdgeWeightedGraph(int v) {
		V = v;
		E = 0;
		adj = new LinkedList[V];
		for(int i =0;i<v;i++){
			adj[i] = new LinkedList<Edge>();
		}
	}
	public int V(){
		return V;
	}
	public int E(){
		return E;
	}
	public void addEdge(Edge e){
		int v = e.either(),w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
	/**
	 * 返回所有的边，每条边返回一个，从小点指向大点
	 * @return
	 */
	public Iterable<Edge> edges(){
		LinkedList<Edge> l = new LinkedList<Edge>();
		for(int v =0;v<V;v++){
			for(Edge e :adj[v]){
				if(e.other(v)>v)
					l.add(e);
			}
		}
		return l;
	}
	
}
