package spanTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class EagerPrim {

    private Edge[] edgeTo;        
    private double[] distTo;     
    private boolean[] marked;     
    private IndexMinPQ<Double> pq;

    public EagerPrim(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;

		distTo[0] = 0.0; 
		pq.insert(0, 0.0);
        while(!pq.isEmpty()){
        	visit(G,pq.delMin());
        }
    }

    public void visit(EdgeWeightedGraph G,int v){
    	marked[v] = true;
    	for(Edge e : G.adj(v)){
    		int w = e.other(v);
//    		if(distTo[w]!=Double.POSITIVE_INFINITY)continue;
    		if(marked[w]) continue;
    		if(distTo[w]>e.weight()){
    			edgeTo[w] = e;
    			distTo[w] = e.weight();
    			if(pq.contains(w)){
    				pq.change(w, distTo[w]);
    			}else{
    				pq.insert(w, distTo[w]);
    			}
    		}
    	}
    }
	public Iterable<Edge> edges(){
		Queue<Edge> mst = new ArrayDeque<Edge>();
		for(int i =1;i<edgeTo.length;i++){
			mst.add(edgeTo[i]);
		}
		return mst;
	}
    public static void main(String[] args) {
    	
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
		EagerPrim ep = new EagerPrim(G);
		for( Edge e :ep.edges()){
			System.out.println(e);
		}
    }
}
