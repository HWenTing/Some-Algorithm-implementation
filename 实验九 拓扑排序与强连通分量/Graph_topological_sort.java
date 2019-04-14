package 算法设计与分析;
import java.util.*; 

public class Graph_topological_sort {
	private int points;
	private LinkedList<Integer> adj[];
	private LinkedList<Integer> sort;
	Graph_topological_sort(int v){
		points=v;
		adj = new LinkedList[v];

		for(int i =0;i<v;i++){
			adj[i]=new LinkedList<Integer>();
		}
	}
	/**
	 * 向图中添加边
	 * @param start
	 * @param end
	 */
	void addEdge(int start,int end){
		adj[start].add(end);
	}
	
	/**
	 * dfs
	 * @param point
	 * @param visited
	 */
	void topological_sort_item(int point,boolean visited[]){
		visited[point]=true;

        Iterator<Integer> it = adj[point].iterator(); 
        Integer neighbor;
        while (it.hasNext()) 
        { 
        	neighbor = it.next(); 
            if (!visited[neighbor]) 
            	topological_sort_item(neighbor,visited); 
        } 
        sort.addFirst(point);
        
	}
	
	/**
	 * 求拓扑排序
	 */
	void topological_sort(){
		sort = new LinkedList<Integer>();
		boolean visited[]= new boolean[points]; 

		for (int i = 0; i < points; i++) 
			visited[i] = false; 
		for (int i =0;i<points;i++){
			if (visited[i] == false){
				topological_sort_item(i,visited);
			}
		}
		
		Iterator<Integer> it =  sort.iterator();
		while (it.hasNext()) 
        { 
			System.out.print(it.next()+" ");
        } 

	}
	
	public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
		Graph_topological_sort g = new Graph_topological_sort(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
  
        System.out.println("Following is a Topological " + 
                           "sort of the given graph"); 
        g.topological_sort(); 
    } 
}
