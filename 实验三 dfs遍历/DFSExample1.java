package 算法设计与分析;
import java.util.Scanner;
public class DFSExample1 {
	static boolean [][]test=new boolean[10][10] ;//判断边是否合法
	static boolean [][]relation;//边是否存在
	static boolean []visit;//点是否被访问到
	static int res;//返回的结果
	static int min_step;//包括点的个数
	static int lines;
	static boolean valid(int i,int j){
		int mid = (i+j)/2;
		if((test[i][j]||test[j][i])&&!visit[mid]){
			return false;
		}
		return true;
	}
	static void dfs(int p,int step,int e){
		visit[p] = true;
		if(step==min_step && e==lines){
			res++;
			return;
		}
		for(int i=1;i<10;++i){
			if(!visit[i]){
				if(!valid(p,i)){
					continue;
				}
				if(relation[p][i]){
					dfs(i,step+1,e+1);
				}else{
					dfs(i,step+1,e);
				}
				visit[i]=false;
			}
		}	
	}
	public static void main(String []args){
		test[1][3]=test[3][1]=test[1][7]=test[7][1]=true;
		test[2][8]=test[8][2]=test[4][6]=test[6][4]=true;
		test[1][9]=test[9][1]=test[3][7]=test[7][3]=true;
		test[9][3]=test[3][9]=test[9][7]=test[7][9]=true;
		Scanner sc = new Scanner(System.in);
		int group=sc.nextInt();
		for(int i =0;i<group;i++){
			lines = sc.nextInt();
			relation=new boolean[10][10] ;
			visit = new boolean[10];
			res = 0;
			
			for(int j=0;j<lines;j++){	
				int temp1 = sc.nextInt();
				int temp2 = sc.nextInt();
				relation[temp1][temp2]=relation[temp2][temp1]=true;
			}
			if(lines+1>4){
				min_step = lines+1;
			}else{
				min_step = 4;
			}
			for(;min_step<10;min_step++){
				for(int k=1;k<10;k++){	
					dfs(k,1,0);
					visit[k]=false;
				}
			}
			System.out.println(res);
		}
	}
}
