package 算法设计与分析;

import java.util.Scanner;

public class DFSExample2 {
	static char[][] matrix  ;
	static int M,N;
	static void dfs(int posx,int posy){
		if(posx<0||posy<0||posx>=M||posy>=N)return;
		if(matrix[posx][posy]=='W'){
			matrix[posx][posy]='.';
			dfs(posx,posy+1);
			dfs(posx,posy-1);
			dfs(posx+1,posy+1);
			dfs(posx+1,posy);
			dfs(posx+1,posy-1);
			dfs(posx-1,posy);
			dfs(posx-1,posy-1);
			dfs(posx-1,posy+1);
		}
	}
	public static void main(String[]args){
		Scanner sc = new Scanner (System.in);
		M = sc.nextInt();//m x m 数组
		N = sc.nextInt();
		sc.nextLine();
		matrix = new char[M][N];
		//读入数据
		for(int i =0;i<M;i++){
			String temp =  sc.nextLine();
			for(int j =0;j<N;j++){
				matrix[i][j]=temp.charAt(j);
			}
		}
		
		int res=0;
		for(int i =0;i<M;i++){
			for(int j =0;j<N;j++){
	            if(matrix[i][j]=='W'){
	                //从有积水的地方开始深搜
	                dfs(i,j);
	                res++;
	            }
			}
		}
		System.out.println(res);	
	}
}
