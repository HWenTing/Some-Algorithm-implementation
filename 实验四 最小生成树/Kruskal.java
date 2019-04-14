package spanTree;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kruskal {
	
	private Queue<Edge> mst;//存放最小边

	public Kruskal(EdgeWeightedGraph G){
		mst = new ArrayDeque<Edge>();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		for(Edge e : G.edges()){
			pq.add(e);
		}
		UF uf = new UF(G.V());
		while(!pq.isEmpty()&&mst.size()<G.V()-1){
			Edge e = pq.poll();
			int v = e.either();
			int w = e.other(v);
			if(uf.connected(v, w))
				continue;
			uf.union(v, w);
			mst.add(e);
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
		Kruskal k = new Kruskal(G);
		for( Edge e :k.edges()){
			System.out.println(e);
		}
	}
	
}
