import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br;

	static String endl = "\n";
	static String blank = " ";
	
	static int N;
	static int p, f, s, v;
	static int[][] board;
	static int[] sel;
	static int ans = Integer.MAX_VALUE;
	static boolean flag = false;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stk();
		p = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		board = new int[N+1][5];
		sel = new int[N+1];
		for (int i = 1; i <= N; i++) {
			stk();
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() throws IOException {
		recur(1, 0, 0, 0, 0, 0);
		if(flag) {
            System.out.println(ans);
            System.out.println(sb);
        }
        else {
            System.out.println(-1);
        }
	}
	
	// 1~6개 중에서 부분집합
	static void recur(int cur, int sumP, int sumF, int sumS, int sumV, int price) {
		if (sumP >= p && sumF >= f && sumS >=s && sumV >= v) {
			if (price < ans) {
				flag = true;
				sb = new StringBuilder();
				ans = price;
				for (int i = 1; i <= N; i++) {
					if (sel[i] == 1) {
						sb.append(i).append(blank);
					}
				}
			}
			return;
		}
		if (cur == N + 1) {
			if (sumP >= p && sumF >= f && sumS >=s && sumV >= v) {
				if (price < ans) {
					flag = true;
					sb = new StringBuilder();
					ans = price;
					for (int i = 1; i <= N; i++) {
						if (sel[i] == 1) {
							sb.append(i).append(blank);
						}
					}
				}
			}
			return;
		}
		sel[cur] = 1;
		recur(cur+1, sumP+board[cur][0], sumF+board[cur][1], sumS+board[cur][2], sumV+board[cur][3], price+board[cur][4]);
		sel[cur] = 0;
		recur(cur+1, sumP, sumF, sumS, sumV, price);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}