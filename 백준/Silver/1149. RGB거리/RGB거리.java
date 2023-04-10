import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br;

	static String endl = "\n";
	static String blank = " ";

	static int N;
	static int[][] home;
	static int[][] dp;
	static int ans = Integer.MAX_VALUE;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		home = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			stk();
			for (int j = 0; j < 3; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
	}

	static void pro() throws IOException {
		dp[0][0] = home[0][0];
		dp[0][1] = home[0][1];
		dp[0][2] = home[0][2];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			recur(1, i);
			min = Math.min(min, recur (1, i) + home[0][i]);
		}
		System.out.println(min);
	}
	
	static int recur(int cur, int prv) {
		if (cur == N)
			return 0;
		
		if (dp[cur][prv] != -1)
			return dp[cur][prv];
		
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (i == prv) continue;
			ans = Math.min(ans, recur (cur + 1, i) + home[cur][i]);
		}
		dp[cur][prv] = ans;
		return ans;
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}