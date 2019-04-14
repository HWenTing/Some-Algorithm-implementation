package 算法设计与分析;
import java.util.Scanner;
//自底向上
public class Fibonacci {
	static long dp[] = new long[90];
	static long fibonacci(int n){
	
		return dp[n-1];
				
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < 90; i++)
			dp[i] = dp[i - 1] + dp[i - 2];//动态规划的状态转移式
		
		int time = sc.nextInt();
		for(int i =0;i<time;i++){
			System.out.println(fibonacci(sc.nextInt()));
		}
	}
}

//自顶向下
//public class Fibonacci {
//	static long dp[] = new long[100];
//	static long fibonacci(int n){
//	    if(n==0||n==1) return n;
//	    if(dp[n]!=0){
//	    	return dp[n];
//	    }else{
//	    	dp[n] = fibonacci(n-1)+fibonacci(n-2);
//	    	return dp[n];
//	    }
//	}
//	public static void main(String[]args){
//		Scanner sc = new Scanner(System.in);
//		int time = sc.nextInt();
//		for(int i =0;i<time;i++){
//			System.out.println(fibonacci(sc.nextInt()));
//		}
//	}
//}

