package sssp;

public class DijkstraAllPairs {
	private Dijkstra[] all;
	DijkstraAllPairs(EdgeWeightedDigraph G){
		all = new Dijkstra[G.V()];
		for(int v = 0;v<G.V();v++){
			all[v] = new Dijkstra(G, v);
		}
	}
	Iterable<DirectedEdge> path(int s,int t){
		return all[s].pathTo(t);
	}
	double dist(int s,int t){
		return all[s].distTo(t);
	}
	
	public static void main(String[]args){
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(6);
		G.addEdge(new DirectedEdge(0, 1, 1));
		G.addEdge(new DirectedEdge(0, 2, 12));
		G.addEdge(new DirectedEdge(1, 3, 3));
		G.addEdge(new DirectedEdge(1, 2, 9));
		G.addEdge(new DirectedEdge(3, 2, 4));
		G.addEdge(new DirectedEdge(3, 4, 13));
		G.addEdge(new DirectedEdge(2, 4, 5));
		G.addEdge(new DirectedEdge(4, 5, 4));
		G.addEdge(new DirectedEdge(3, 5, 15));

		DijkstraAllPairs Da = new DijkstraAllPairs(G);
		System.out.println(Da.dist(2, 3));

	}
}
