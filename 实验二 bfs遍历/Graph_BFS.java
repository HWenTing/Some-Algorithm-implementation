package 算法设计与分析;
import java.io.*; 
import java.util.*; 

/**
 * BFS for a Graph
 * @author HP
 *
 */
public class Graph_BFS {
	private int points;
	private LinkedList<Integer> adj[];
	private final int ini=-1;
	private final int white=0;
	private final int gray=1;
	private final int black=2;
	
	private int[] pi;
	private int[] d ;
	private int[] color;
	
	Graph_BFS(int v){
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
	
	int[] getD(){
		return d;
	}
	
	void printD(){
		for(int i=0;i<points;i++){
			System.out.println("顶点"+i+"的距离为"+d[i]);
		}
	}
	
	void printColor(){
		for(int i=0;i<points;i++){
			System.out.println("顶点"+i+"的color是"+color[i]);
		}
	}
	
	/**
	 * start from a certain point
	 * @param startpoint
	 */
	void bfs(int startpoint){
		
		pi=new int[points];
		d = new int[points];
		color=new int[points];
		
		for(int i =0;i<points;i++){
			pi[i]=-1;
			d[i]=ini;
			color[i]=white;
		}
		
		pi[startpoint]=startpoint;
		d[startpoint]=0;
		color[startpoint]=gray;
		
        LinkedList<Integer> queue = new LinkedList<Integer>(); 

        queue.add(startpoint);
        
        while(queue.size()!=0){
            startpoint = queue.poll(); 
            System.out.print(startpoint+" "); 
            for(int j=0;j<adj[startpoint].size();j++){
            	int p=adj[startpoint].get(j);
            	if(color[p]==white){
            		color[p]=gray;
            		d[p]=d[startpoint]+1;
            		pi[p]=startpoint;
            		queue.add(p);
            	}
            }
            color[startpoint]=black;
        }
		
	}
	
	 public static void main(String args[]) 
	    { 
		 Graph_BFS g = new Graph_BFS(4); 
	  
	        g.addEdge(0, 1); 
	        g.addEdge(0, 2); 
	        g.addEdge(1, 2); 
	        g.addEdge(2, 0); 
	        g.addEdge(2, 3); 
	        g.addEdge(3, 3); 
		 
		 	
	        System.out.println("以顶点2为起点进行宽度优先搜索");
	        g.bfs(2); 
	        System.out.println();
	        System.out.println("-------------------------");
	        g.printPi();
	        System.out.println("-------------------------");
	        g.printColor();
	        System.out.println("-------------------------");
	        g.printD();
	        System.out.println("-------------------------");
	    } 
	 
}
