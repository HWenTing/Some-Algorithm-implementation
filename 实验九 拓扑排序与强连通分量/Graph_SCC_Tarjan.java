package 算法设计与分析;

import java.util.*;
/**
 * 变量DFN[u]：表示在深度搜索中遍历到该节点的次序。
 * LOW(u)表示以u节点为树根，u及u以下树节点所能找到的最小次序号
 * @author HP
 *
 */
public class Graph_SCC_Tarjan {
	private int points;
	private LinkedList<Integer> adj[];
	private boolean[] visited;
	private LinkedList<Integer> path;
	private LinkedList<LinkedList<Integer>> scc;
	private int[] dfn;
	private int[] low;
	private int deep;
 	Graph_SCC_Tarjan(int v){
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
	 * get强连通分量链表
	 * @return
	 */
	public LinkedList<LinkedList<Integer>> getScc() {
		return scc;
	}
	
	/**
	 * 打印链表
	 * @param ppp
	 */
	void print_LinkedList(LinkedList<Integer> ppp){
		for(Integer ii :ppp){
			System.out.print(ii+" ");
		}
		System.out.println();
	}
	
	/**
	 * 递归调用算法
	 * @param point
	 */
	void tarjan_item(int point){
		dfn[point] = deep++;
		low[point] = dfn[point];
		visited[point]=true;
		path.addFirst(point);

		Iterator<Integer> it = adj[point].iterator(); 
        Integer neighbor;
        while (it.hasNext()) 
        { 
        	neighbor = it.next(); 
            if (!visited[neighbor]) {
            	tarjan_item(neighbor); 
            	low[point] = Math.min(low[point], low[neighbor]);
            }else if(path.contains(neighbor)){
            	low[point] = Math.min(low[point], dfn[neighbor]);
            }
            	
        } 
        if(low[point]==dfn[point]){
        	scc.add(new LinkedList<Integer>());
        	while(true){
	        	int temp = path.poll();
	            scc.getLast().add(temp);
	            if(point==temp){
	            	break;
	            }
        	}  
        }
        
        
	}
	
	/**
	 * tarjan方法求强连通分量
	 */
	void tarjan(){
		dfn=new int[points];
		low=new int[points];
		deep=0;
		path = new LinkedList<Integer>();
		scc=new LinkedList<LinkedList<Integer>>();
		
		visited= new boolean[points]; 
		for (int i = 0; i < points; i++) 
			visited[i] = false; 
		for (int i=0;i<points;i++){

			if(visited[i]==false){
				tarjan_item(i);
			}
		}
		
		for(LinkedList<Integer> i : scc){
			print_LinkedList(i);
		}
		
	}
	
	 public static void main(String args[]) 
	    { 
	        // Create a graph given in the above diagram 
		 	Graph_SCC_Tarjan g = new Graph_SCC_Tarjan(5); 
	        g.addEdge(1, 0); 
	        g.addEdge(0, 2); 
	        g.addEdge(2, 1); 
	        g.addEdge(0, 3); 
	        g.addEdge(3, 4); 
	  
	        System.out.println("Tarjan  Following are strongly connected components "+ 
	                           "in given graph "); 
	        g.tarjan(); 
	    } 
}
