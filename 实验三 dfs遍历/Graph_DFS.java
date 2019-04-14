package 算法设计与分析;

import java.io.*; 
import java.util.*; 

/**
 * DFS for a Graph
 * @author Tinghw
 *
 */
public class Graph_DFS {
	private int points;
	private LinkedList<Integer> adj[];
	private final int ini=-1;
	private final int white=0;
	private final int gray=1;
	private final int black=2;
	private int time;
	
	private int[] pi;
	private int[] d ;
	private int[] f;
	private int[] color;
	
	Graph_DFS(int v){
		points=v;
		adj = new LinkedList[v];
		for(int i =0;i<v;i++){
			adj[i]=new LinkedList();
		}
	}
	
	void addEdge(int start,int end){
		adj[start].add(end);
	}
	
	int[] getPi(){
		return pi;
	}
	
	void printPi(){
		for(int i=0;i<points;i++){
			System.out.println("顶点"+i+"的前驱是"+pi[i]);
		}
	}
	
	int[] getF(){
		return f;
	}
	
	int[] getD(){
		return d;
	}
	
	void printD(){
		for(int i=0;i<points;i++){
			System.out.println("顶点"+i+"的发现时间"+d[i]);
		}
	}
	void printF(){
		for(int i=0;i<points;i++){
			System.out.println("顶点"+i+"的完成时间"+f[i]);
		}
	}
	
	void printColor(){
		for(int i=0;i<points;i++){
			System.out.println("顶点"+i+"的color是"+color[i]);
		}
	}
/**
 * start from a certain point
 * @param startPoint
 */
	void dfs(int startPoint){
		pi=new int[points];
		d = new int[points];
		f = new int[points];
		color=new int[points];
		time=0;
		
		for(int i =0;i<points;i++){
			pi[i]=-1;
			d[i]=ini;
			f[i]=ini;
			color[i]=white;
		}
		dfs_visit(startPoint,startPoint);
					
	}
	
	void dfs_visit(int father,int point){
		time+=1;
		color[point]=gray;
		d[point]=time;
		pi[point]=father;
		System.out.print(point+" ");
		for(int j=0;j<adj[point].size();j++){
        	int p=adj[point].get(j);
        	if(color[p]==white){
        		dfs_visit(point,p);
        	}
        }
		color[point]=black;
		time+=1;
		f[point]=time;
	}
	
	public static void main(String args[]) 
    { 
	 Graph_DFS g = new Graph_DFS(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
	 	 	
        System.out.println("以顶点2为起点进行深度搜索"); 
        g.dfs(2); 
        System.out.println();
        System.out.println("-------------------------");
        g.printPi();
        System.out.println("-------------------------");
        g.printColor();
        System.out.println("-------------------------");
        g.printD();
        System.out.println("-------------------------");
        g.printF();
    } 
}

