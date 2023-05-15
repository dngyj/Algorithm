import java.io.*;
import java.util.*;

public class Main {
	static int N,max;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] arr,dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N];
		max = 1;
		StringTokenizer st;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N; j++) {
				dfs(i,j);
			}
		}
		
		System.out.println(max);
	}
	
	static int dfs(int r, int c) {
		if(dp[r][c] != 0) return dp[r][c];
		
		dp[r][c] = 1; 
		
		for(int i = 0; i < 4; i++) {
			if(check(r + dr[i], c + dc[i])) {
				if(arr[r + dr[i]][c + dc[i]] > arr[r][c]) {
					dp[r][c] = Math.max(dp[r][c], dfs(r + dr[i], c + dc[i])+1);
				}
			}
		}

		if(dp[r][c] > max) max = dp[r][c];
		return dp[r][c];
	}
	
	static boolean check(int r, int c) {
		if(r<0 || r>=N || c<0 || c>=N) return false;
		else return true;
	}
}