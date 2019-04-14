package spanTree;

public class UF {
	private int[]id;//记录父节点
	private int count;//分支数量
	private int[]size;//记录分支权重，节点数目
	
	
	public UF(int N){
		count = N;
		id = new int[N];
		size = new int[N];
		for (int i =0;i<N;i++){
			id[i] = i;;
			size[i] = 1;//初始化
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
		if(size[left]<size[right]){
			id[left] = right;
			size[right]+=size[left];
		}else{
			id[right] = left;
			size[left]+=size[right];
		}
		count--;
	}	
}


