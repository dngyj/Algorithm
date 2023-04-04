import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br;

	static String endl = "\n";
	static String blank = " ";
	
	static int N;
	static int[] dp;
	static int ans = Integer.MAX_VALUE;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
	}

	/* 1부터 N까지의 수 중 제곱수들의 합
	 * dp[n] => n을 표현하는 제곱수 항의 최소 개수
	 * 
	 * dp[1] = 1
	 * dp[2] = dp[1] + dp[1] = 2
	 * dp[3] = dp[2] + dp[1]
	 * 		 = dp[1] + dp[1] + dp[1] = 3
	 * dp[4] = 1
	 * dp[5] = dp[4] + dp[1] = 2
	 * 
	 * => 제곱수이면 1
	 * 
	 * 제곱수 조합을 모두 구해 최솟값을 구한다.
	 */
	
	static void pro() throws IOException {
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i] = i;
		} 
		// 제곱수 조합을 모두 구해 최솟값을 구한다.
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
//									        이전의 값에 dp[j*j] 를 더해주기 때문에 +1
			}
		}
		System.out.println(dp[N]);
	}
	
	static int recur(int n) {
		if(dp[n] != -1)
			return dp[n];
		
		dp[n] = recur(n-1) + dp[1];
		return dp[n];
	}
		
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}