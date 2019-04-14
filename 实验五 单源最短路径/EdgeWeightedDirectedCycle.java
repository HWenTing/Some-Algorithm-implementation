package sssp;
import java.util.ArrayDeque;
import java.util.Queue;
public class EdgeWeightedDirectedCycle {
	private boolean[] marked;             
    private DirectedEdge[] edgeTo;        
    private boolean[] onStack;            
    private Queue<DirectedEdge> cycle;    

    public EdgeWeightedDirectedCycle(EdgeWeightedDigraph G) {
        marked  = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo  = new DirectedEdge[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }
    private void dfs(EdgeWeightedDigraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (cycle != null) return;
            else if (!marked[w]) {
                edgeTo[w] = e;
                dfs(G, w);
            }
            else if (onStack[w]) {
                cycle = new ArrayDeque<DirectedEdge>();
                DirectedEdge f = e;
                while (f.from() != w) {
                    cycle.add(f);
                    f = edgeTo[f.from()];
                }
                cycle.add(f);

                return;
            }
        }
        onStack[v] = false;
    }
    public boolean hasCycle() {
        return cycle != null;
    }
    public Iterable<DirectedEdge> cycle() {
        return cycle;
    }
}
