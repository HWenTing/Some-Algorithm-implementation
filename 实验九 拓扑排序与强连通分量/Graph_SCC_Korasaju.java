package 算法设计与分析;

import java.util.*; 

/**
 * Kosaraju是基于对有向图及其逆图两次DFS的方法，其时间复杂度也是 O(N+M)
 * Tarjan只用对原图进行一次DFS，不用建立逆图，更简洁,其时间复杂度也是 O(N+M)
 * 此出用Kosaraju算法实现
 * @author HP
 *
 */
public class Graph_SCC_Korasaju {
	private int points;
	private LinkedList<Integer> adj[];
	private LinkedList<Integer> sort;
	private LinkedList<LinkedList<Integer>> scc;
	Graph_SCC_Korasaju(int v){
		points=v;
		adj = new LinkedList[v];
		sort = new LinkedList<Integer>();
		scc=new LinkedList<LinkedList<Integer>>();
		for(int i =0;i<v;i++){
			adj[i]=new LinkedList<Integer>();
		}
	}
	
	/**
	 * get强连通分量链表
	 * @return
	 */
	public LinkedList<LinkedList<Integer>> getScc() {
		return scc;
	}

	/**
	 * 设置强连通分量链表
	 * @param scc
	 */
	public void setScc(LinkedList<LinkedList<Integer>> scc) {
		this.scc = scc;
	}

	/**
	 * 得到遍历序列
	 * @return
	 */
	public LinkedList<Integer> getSort() {
		return sort;
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
	 * 原图中dfs函数
	 * @param point
	 * @param visited
	 */
	void dfs_visit(int point,boolean visited[]){
		visited[point]=true;

        Iterator<Integer> it = adj[point].iterator(); 
        Integer neighbor;
        while (it.hasNext()) 
        { 
        	neighbor = it.next(); 
            if (!visited[neighbor]) 
            	dfs_visit(neighbor,visited); 
        } 
        sort.addFirst(point);
	}
	
	/**
	 * 转置图中dfs函数
	 * @param point
	 * @param visited
	 */
	void dfs_scc(int point,boolean visited[]){
		visited[point]=true;

        Iterator<Integer> it = adj[point].iterator(); 
        Integer neighbor;
        while (it.hasNext()) 
        { 
        	neighbor = it.next(); 
            if (!visited[neighbor]) 
            	dfs_scc(neighbor,visited); 
        } 
        sort.add(point);
        scc.getLast().add(point);
	}
	
	
	/**
	 * 得到转置邻接表
	 * @return
	 */
	Graph_SCC_Korasaju getTranspose() 
    { 
		Graph_SCC_Korasaju g = new Graph_SCC_Korasaju(points); 
        for (int v = 0; v < points; v++) 
        { 
            Iterator<Integer> i =adj[v].listIterator(); 
            while(i.hasNext()) 
                g.adj[i.next()].add(v); 
        } 
        return g; 
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
	 * 求解强连通分量
	 */
	void kosaraju_SCC(){
		sort = new LinkedList<Integer>();
		boolean visited[]= new boolean[points]; 
		for (int i = 0; i < points; i++) 
			visited[i] = false; 
		for (int i =0;i<points;i++){
			if (visited[i] == false){
				dfs_visit(i,visited);
			}
		}
		LinkedList<Integer> ppp =getSort();
		print_LinkedList(ppp);
		
		Graph_SCC_Korasaju T = getTranspose();
		for (int i = 0; i < points; i++) 
			visited[i] = false; 
		Iterator<Integer> it =  sort.iterator();
		while (it.hasNext()) 
        { 
			int pos=it.next();
			if(visited[pos]==false){
				LinkedList<LinkedList<Integer>> temp =T.getScc();
				temp.add(new LinkedList<Integer>());
				T.setScc(temp);
				T.dfs_scc(pos, visited);
			}

        } 
		//输出
		for(LinkedList<Integer> i : T.getScc()){
			print_LinkedList(i);
		}
		
	}
	 public static void main(String args[]) 
	    { 
	        // Create a graph given in the above diagram 
		 	Graph_SCC_Korasaju g = new Graph_SCC_Korasaju(5); 
	        g.addEdge(1, 0); 
	        g.addEdge(0, 2); 
	        g.addEdge(2, 1); 
	        g.addEdge(0, 3); 
	        g.addEdge(3, 4); 
	  
	        System.out.println("Korasaju Following are strongly connected components "+ 
	                           "in given graph "); 
	        g.kosaraju_SCC(); 
	    } 
	
}
