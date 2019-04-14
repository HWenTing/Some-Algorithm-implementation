package spanTree;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prim {

	private boolean[] marked;
	private Queue<Edge> mst;//存放最小边
	private PriorityQueue<Edge> pq ;
	
	public Prim(EdgeWeightedGraph G){
		pq = new PriorityQueue<Edge>();
		marked = new boolean[G.V()];
		mst = new ArrayDeque<Edge>();
		visit(G,0);
		while(!pq.isEmpty()){
			Edge e = pq.poll();
			int v = e.either();
			int w = e.other(v);
			if(marked[v]&&marked[w]){
				continue;
			}
			mst.add(e);
			if(!marked[v]) visit(G, v);
			if(!marked[w]) visit(G, w);
		}
	}	
	private void visit(EdgeWeightedGraph G,int v){
		marked[v] = true;
		for (Edge e:G.adj(v)){
			if(!marked[e.other(v)])
				pq.add(e);
		}
	}
	public Iterable<Edge> edges(){
		return mst;
	}
	
	public static void main(String[]args){
		EdgeWeightedGraph G = new EdgeWeightedGraph(6);
		G.addEdge(new Edge(0, 2, 1));
		G.addEdge(new Edge(0, 1, 6));
		G.addEdge(new Edge(0, 3, 5));
		G.addEdge(new Edge(1, 2, 5));
		G.addEdge(new Edge(3, 2, 5));
		G.addEdge(new Edge(4, 2, 6));
		G.addEdge(new Edge(5, 2, 4));
		G.addEdge(new Edge(1, 4, 3));
		G.addEdge(new Edge(5, 3, 2));
		Prim p = new Prim(G);
		for( Edge e :p.edges()){
			System.out.println(e);
		}
	}
	
}
