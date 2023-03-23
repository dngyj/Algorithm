import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br;

	static String endl = "\n";
	static String blank = " ";

	static int N;
	static int[] queen;
	static int cnt;

	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		int ans = 0;
		queen = new int[N];
		cnt = 0;
		recur(0);
		System.out.println(cnt);
	}

	static void recur(int row) {
		if (row == N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!isPossible(row, i))
				continue;
			queen[row] = i;
			recur(row + 1);
		}
	}

	static boolean isPossible(int row, int i) {
		for (int j = 0; j < row; j++) {
			if (queen[j] == i) return false;
			if (j - row == queen[j] - i) return false;
			if (j - row == -(queen[j] - i)) return false;
		}
		return true;
	}

	static boolean inRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}