import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br;

	static String endl = "\n";
	static String blank = " ";

	static int N, M;
	static int[][] arr;
	static int[][] dp;
	static int max = Integer.MIN_VALUE;

	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			stk();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
	}

	static void pro() throws IOException {
		dp[0][0] = arr[0][0];
		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i - 1][0] + arr[i][0];
		}
		for (int i = 1; i < M; i++) {
			dp[0][i] = dp[0][i - 1] + arr[0][i];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				dp[i][j] = Math.max(dp[i][j - 1] + arr[i][j], dp[i - 1][j] + arr[i][j]);
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + arr[i][j]);
			}
		}
		System.out.println(dp[N - 1][M - 1]);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}