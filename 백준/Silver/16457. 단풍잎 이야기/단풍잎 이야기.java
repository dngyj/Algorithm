import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br;

	static String endl = "\n";
	static String blank = " ";

	static int n;
	static int m;
	static int k;
	static int[][] skill;
	static int[] arr;
	static int max = Integer.MIN_VALUE;

	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		stk();
		n = Integer.parseInt(st.nextToken()); // 키의 개수
		m = Integer.parseInt(st.nextToken()); // 퀘스트의 개수
		k = Integer.parseInt(st.nextToken()); // 퀘스트 당 사용할 수 있는 스킬 수
												// 2n=스킬의 개수
		skill = new int[m][k];
		for (int i = 0; i < m; i++) {
			stk();
			for (int j = 0; j < k; j++) {
				skill[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	// 2n개의 스킬 중 n개로 최대로 깰 수 있는 퀘스트 개수?
	// 스킬이름 : 1~2n
	// k개
	static void pro() throws IOException {
		arr = new int[n];
		recur(0, 1);
		System.out.println(max);
	}

	static void recur(int cur, int start) {
		if (cur == n) {
			int ans = 0;
			for (int i = 0; i < m; i++) {
				int cnt = 0;
				for (int j = 0; j < k; j++) {
					for (int k = 0; k < n; k++) {
						if (skill[i][j] == arr[k]) {
							cnt++;
						}
					}
				}
				if (cnt == k) {
					ans++;
				}
			}
			max = Math.max(max, ans);
			return;
		}
		for (int i = start; i <= 2 * n; i++) {
			arr[cur] = i;
			recur(cur + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}