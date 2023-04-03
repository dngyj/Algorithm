import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		char[][] board = new char[N][M];
		char[][] Wchess = new char[N][M];
		char[][] Bchess = new char[N][M];
		int[][] Wcount = new int[N][M];
		int[][] Bcount = new int[N][M];

		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < M; c++) {
				board[r][c] = str.charAt(c);
			}
		}

		for (int r = 0; r < N; r += 2) {
			for (int c = 1; c < M; c += 2) {
				Wchess[r][c] = 'B';
			}
			for (int c = 0; c < M; c += 2) {
				Wchess[r][c] = 'W';
			}
		}
		for (int r = 1; r < N; r += 2) {
			for (int c = 0; c < M; c += 2) {
				Wchess[r][c] = 'B';
			}
			for (int c = 1; c < M; c += 2) {
				Wchess[r][c] = 'W';
			}
		}
		for (int r = 0; r < N; r += 2) {
			for (int c = 1; c < M; c += 2) {
				Bchess[r][c] = 'W';
			}
			for (int c = 0; c < M; c += 2) {
				Bchess[r][c] = 'B';
			}
		}
		for (int r = 1; r < N; r += 2) {
			for (int c = 0; c < M; c += 2) {
				Bchess[r][c] = 'W';
			}
			for (int c = 1; c < M; c += 2) {
				Bchess[r][c] = 'B';
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (Wchess[r][c] != board[r][c])
					Wcount[r][c] = 1;
				if (Bchess[r][c] != board[r][c])
					Bcount[r][c] = 1;
			}
		}

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N - 8 + 1; i++) {
			for (int k = 0; k < M - 8 + 1; k++) {
				int Wsum = 0;
				int Bsum = 0;
				for (int r = i; r < i + 8; r++) {
					for (int c = k; c < k + 8; c++) {
						Wsum += Wcount[r][c];
						Bsum += Bcount[r][c];
					}
				}
				min = Math.min(min, Math.min(Bsum, Wsum));
			}
		}
		System.out.println(min);
	}
}