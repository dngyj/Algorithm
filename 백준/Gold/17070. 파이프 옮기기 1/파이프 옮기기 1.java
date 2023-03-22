import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br;

	static String endl = "\n";
	static String blank = " ";

	static int N;
	static int[][] board;
	static int cnt = 0;

	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int r = 0; r < N; r++) {
			stk();
			for (int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() throws IOException {
		pipe(0, 0, 0, 1);
		System.out.println(cnt);
	}

	static void pipe(int x1, int y1, int x2, int y2) {
		// 경계값 확인
		if (!inRange(x2, y2)) {
			return;
		}
		// 가로, 세로 뒤에 벽 있는지 확인
		if (board[x2][y2] == 1) {
			return;
		}
		// 대각선일때 뒤에 벽 있는지 확인
		if (x2 == x1 + 1 && y2 == y1 + 1) {
			if (board[x2][y2 - 1] == 1 || board[x2 - 1][y2] == 1) {
				return;
			}
		}
		if (x2 == N - 1) {
			if (y2 == N - 1) {
				cnt++;
				return;
			}
		}
		// 가로
		if (x2 == x1 && y2 == y1 + 1) {
			pipe(x1, y1 + 1, x2, y2 + 1);
			pipe(x1, y1 + 1, x2 + 1, y2 + 1);
			// 세로
		} else if (x2 == x1 + 1 && y2 == y1) {
			pipe(x1 + 1, y1, x2 + 1, y2);
			pipe(x1 + 1, y1, x2 + 1, y2 + 1);
			// 대각선
		} else if (x2 == x1 + 1 && y2 == y1 + 1) {
			pipe(x1 + 1, y1 + 1, x2, y2 + 1);
			pipe(x1 + 1, y1 + 1, x2 + 1, y2);
			pipe(x1 + 1, y1 + 1, x2 + 1, y2 + 1);
		}

	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}