package 算法设计与分析;
import java.util.*; 
import java.lang.*; 
import java.io.*; 
public class UnionFind_QuickUnion{
	private int[]id;//记录父节点
	private int count;//分支数量
	public UnionFind_QuickUnion(int N){
		count = N;
		id = new int[N];
		for (int i =0;i<N;i++){
			id[i] = i;;
		}
	}
	public void printId(){
		for (int i =0;i<id.length;i++){
			System.out.print(i+" ");
		}
		System.out.println();
		for (int i =0;i<id.length;i++){
			System.out.print(id[i]+" ");
		}
	}
	
	public int count(){
		return count;
	}
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	public int find(int p ){
		while(id[p]!=p){
			p = id[p];
		}
		return p;
	}	
	public void union(int p,int q){
		int left = find(p);
		int right = find(q);
		if(left == right) return;
		id[left] = right;
		count--;
	}
	public static void main(String []args) {
		UnionFind_QuickUnion uf= new UnionFind_QuickUnion(10);

		uf.union(4, 3);
		uf.union(3, 8);
		uf.union(6, 5);
		uf.union(9, 4);
		uf.union(2, 1);
		uf.union(8, 9);
		uf.union(5, 0);
		uf.union(7, 2);
		uf.union(6, 1);
		uf.union(1, 0);
		uf.union(6, 7);
		
		uf.printId();
	}
}
