package 算法设计与分析;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

class Node{
	int row,column,step;
	Node(int row,int column,int step){
		this.row = row;
		this.column = column;
		this.step = step;
	}
}

public class BFSExample1 {
	static char[][] matrix  ;
	static int[][] dis;
	static int row,column;
	static int res;
	static LinkedList<Node> que ;
	static Map<Integer, Node> dictToCoordinate ;//根据个数得到坐标
	static Map<Integer, Integer> dictToNum ;//根据坐标得到个数
	static void print(){

		for(int i =0;i<row;i++){
			for(int j=0;j<column;j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	
	static void bfs(int source,int srow,int scolumn){
		int step = 0;
		boolean[][] visit =  new boolean[row][column] ;
		int[][] steps =  new int[row][column] ;
		que.add(new Node(srow,scolumn,0));
		visit[srow][scolumn]=true;
		while(!que.isEmpty()){
			Node first = que.pop();
			int temp_r = first.row;
			int temp_c = first.column;
			
			if(!visit[temp_r][temp_c]&&matrix[temp_r][temp_c]!='#'){
				
			}
		}
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int group=sc.nextInt();
		for(int k =0;k<group;k++){
			//获取行列值
			column = sc.nextInt();
			row = sc.nextInt();
			//初始化
			matrix = new char[row][column];//读入序列

			res = 0;//所求结果
			que = new LinkedList<Node>(); //栈
			dictToCoordinate = new HashMap<Integer, Node>();
			dictToNum = new HashMap<Integer, Integer>();
			sc.nextLine();
			
			int point_nums = 0;//A点的个数
			
			//从输入获取图
			for(int i =0;i<row;i++){
				String temp =  sc.nextLine();
				for(int j=0;j<column;j++){
					if(temp.charAt(j)=='S'){
						dictToCoordinate.put(0, new Node(i,j,0));
						dictToNum.put(i*column+j, 0);
					}
					if(temp.charAt(j)=='A'){
						point_nums++;
						dictToCoordinate.put(point_nums, new Node(i,j,0));
						dictToNum.put(i*column+j, point_nums);
					}
					matrix[i][j]=temp.charAt(j);
				}
			}
			
			dis = new int[point_nums+1][point_nums+1];
			
			for(int i=0;i<=point_nums;i++){
				
				bfs(i,dictToCoordinate.get(i).row,dictToCoordinate.get(i).column);
			}
		}
	}
}
