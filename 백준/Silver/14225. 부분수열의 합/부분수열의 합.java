import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br;

	static String endl = "\n";
	static String blank = " ";

	static int N;
	static int[] S;
	static int[] flag = new int[2000001];
	static int cnt = 0;

	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		stk();
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		recur(0, 0);
		for (int i = 1; i < flag.length; i++) {
			if (flag[i] == 0) {
				System.out.println(i);
				break;
			}
		}
	}
	
	static void recur(int cur, int total) {
		if (cur == N) {
			flag[total] = 1;
			return;
		}
		recur(cur+1, total+S[cur]);
		recur(cur+1, total);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}