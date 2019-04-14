package sssp;

import java.util.ArrayDeque;
import java.util.Queue;

import spanTree.Prim;

public class Dijkstra {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;
	
	public Dijkstra(EdgeWeightedDigraph G,int s){
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		
		for(int v =0;v<G.V();v++){
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0;
		pq.insert(s,0.0);
		while(!pq.isEmpty()){
			relax(G,pq.delMin());
		}
	}
	
	private void relax(EdgeWeightedDigraph G,int v){
//		System.out.println(v);
//		System.out.println("-----------------------");
		for(DirectedEdge e : G.adj(v)){
			int w = e.to();
//			System.out.println("遍历到的边"+w);

			if(distTo[w]>distTo[v]+e.weight()){
				distTo[w] = distTo[v]+e.weight();
				edgeTo[w] = e;
//				System.out.println("权重需要更新"+distTo[w]);
				if(pq.contains(w)){
//					System.out.println("更新了权重"+distTo[w]);				
					pq.change(w,distTo[w]);
				}else{
//					System.out.println("插入新点的权重"+distTo[w]);		
					pq.insert(w,distTo[w]);
				}

			}
		}
//		System.out.println("-----------------------");
	}
	
	public double distTo(int v){
		return distTo[v];
	}
	
	public boolean hasPathTO(int v){
		return distTo[v]<Double.POSITIVE_INFINITY;
	}
	public Iterable<DirectedEdge> pathTo(int v){
		if(!hasPathTO(v)){
			return null;
		}
		Queue<DirectedEdge> path = new ArrayDeque<DirectedEdge>();
		for(DirectedEdge e = edgeTo[v];e!=null;e = edgeTo[e.from()]){
			path.add(e);
		}
		return path;
	}
	
	public static void main(String[]args){
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(6);
		G.addEdge(new DirectedEdge(0, 1, 1));
		G.addEdge(new DirectedEdge(0, 2, 12));
		G.addEdge(new DirectedEdge(1, 3, 3));
		G.addEdge(new DirectedEdge(1, 2, 9));
		G.addEdge(new DirectedEdge(3, 2, 4));
//		G.addEdge(new DirectedEdge(3, 4, -8));
		G.addEdge(new DirectedEdge(4, 3, -8));

		G.addEdge(new DirectedEdge(2, 4, 5));
		G.addEdge(new DirectedEdge(4, 5, 4));
		G.addEdge(new DirectedEdge(3, 5, 15));

		Dijkstra D = new Dijkstra(G,0);
		for(int i =0;i<6;i++){
			System.out.println(D.distTo(i));
			System.out.println(D.pathTo(i));
		}

	}
}
