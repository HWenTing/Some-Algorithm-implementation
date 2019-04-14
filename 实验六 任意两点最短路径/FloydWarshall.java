package 算法设计与分析;

import sssp.DirectedEdge;
import sssp.EdgeWeightedDigraph;

public class FloydWarshall {
	private int V;
	private double[][] dist;
	public FloydWarshall(EdgeWeightedDigraph G){
		V = G.V();
		dist = new double[G.V()][G.V()];
		//初始化
		for(int v =0;v<G.V();v++){
			
			for(int v2 =0;v2<G.V();v2++){
				dist[v][v2] = Double.POSITIVE_INFINITY;
			}
			dist[v][v] = 0;
			for(DirectedEdge e : G.adj(v)){
				dist[e.from()][e.to()] = e.weight();
			}
		}
		ssp();
	}
	private void ssp(){
		for(int k=0;k<V;k++){
			for(int i =0;i<V;i++){
				for(int j =0;j<V;j++){
					if(dist[i][j]>dist[i][k]+dist[k][j]){
						dist[i][j]=dist[i][k]+dist[k][j];

					}
				}
			}
		}
	}
	
	double[][] mindist(){
		return dist;
	}
	public void print(){
		for(int i=0;i<V;i++){
			System.out.print(i+"\t");
			for(int j = 0;j<V;j++){
				System.out.print(dist[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public boolean hasNegativeCycle(){
		boolean flag = false;
		for(int i =0;i<V;i++){
			if(dist[i][i]<0)
				flag = true;
		}
		return flag;
	}
	public static void main(String[]args){
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(6);
		G.addEdge(new DirectedEdge(0, 1, 1));
		G.addEdge(new DirectedEdge(0, 2, 12));
		G.addEdge(new DirectedEdge(1, 3, 3));
		G.addEdge(new DirectedEdge(1, 2, 9));
		G.addEdge(new DirectedEdge(3, 2, 4));
		G.addEdge(new DirectedEdge(4, 3, -8));
		G.addEdge(new DirectedEdge(2, 4, 5));
		G.addEdge(new DirectedEdge(4, 5, 4));
		G.addEdge(new DirectedEdge(3, 5, 15));
		FloydWarshall D = new FloydWarshall(G);
		D.print();
		System.out.println(D.hasNegativeCycle());
	}
	
}
