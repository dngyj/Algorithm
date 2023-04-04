import java.util.Scanner;

public class Main {

	static int N, cnt;
	static int[][] board;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		board = new int[N][N];
		cnt = 0;

		function(0);
		System.out.println(cnt);

	}

	private static void function(int index) {
		if (index == N) {
			cnt++;
		} else {
			for (int i = 0; i < N; i++) {
				if (isPossible(index, i)) {
					board[index][i] = 1;
					function(index + 1);
					board[index][i] = 0;
				}
			}
		}
	}

	private static boolean isPossible(int r, int c) {

		for (int i = r; i >= 0; i--) {
			if (board[i][c] == 1)
				return false;
		}
		for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}
		for (int i = r, j = c; i >= 0 && j < N; i--, j++) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

}