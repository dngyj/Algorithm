import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br;

	static String endl = "\n";
	static String blank = " ";

	static int[] score = new int[10];
	static int[] arr = new int[3];
	static int[] output = new int[10];
	static boolean[] visited = new boolean[6];
	static int cnt = 0;
	static int ans = 0;

	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		stk();
		for (int i = 0; i < 10; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		dupliPerm(0);
		System.out.println(ans);
	}

	static void dupliPerm(int cur) {
		if (cur == 10) {
			cnt = 0;
			for (int i = 0; i < 10; i++) {
				if(output[i] == score[i]) {
					cnt++;
				}
			}
			if (cnt >= 5) {
				ans++;
			}
			return;
		}
		for (int i = 1; i <= 5; i++) {
			if (cur >= 2) {
				if (output[cur-2] == output[cur-1] && output[cur-1] == i) continue;
			}
			output[cur] = i;
			dupliPerm(cur + 1);
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