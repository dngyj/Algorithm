import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[][] house;
	static int N;
	static int result;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		house = new int[N + 2][N + 2];

		for (int r = 0; r < N + 2; r++) {
			Arrays.fill(house[r], 1);
		}

		for (int r = 1; r < N + 1; r++) {
			for (int c = 1; c < N + 1; c++) {
				house[r][c] = sc.nextInt();
			}
		}

		result = 0;
		pipe(1, 1, 2);
		
		System.out.println(result);
	}

	// 1 : 가로 2 : 세로 3 : 대각
	private static void pipe(int direction, int r, int c) {
		int[] dr = { 0, 0, 1, 1 };
		int[] dc = { 0, 1, 0, 1 };

		if(house[r][c]==1) return;

		if (r == N && c == N) {
			result++;
		}
		
		else {
			switch (direction) {
			case 1:
				if (house[r + dr[1]][c + dc[1]] == 0) {
					pipe(1, r + dr[1], c + dc[1]);
				}
				if (house[r + dr[3]][c + dc[3]] == 0 && house[r + dr[3]][c + dc[3] - 1] == 0 && house[r + dr[3] - 1][c + dc[3]] == 0)
					pipe(3, r + dr[3], c + dc[3]);
				 else return;
				break;

			case 2:
				if (house[r + dr[2]][c + dc[2]] == 0)
					pipe(2,  r + dr[2], c + dc[2]);

				if (house[r + dr[3]][c + dc[3]] == 0 && house[r + dr[3]][c + dc[3] - 1] == 0 && house[r + dr[3] - 1][c + dc[3]] == 0)
					pipe(3, r + dr[3], c + dc[3]);
				else return;
				break;

			case 3:
				if (house[r + dr[1]][c + dc[1]] == 0) {
					pipe(1, r + dr[1], c + dc[1]);
				}

				if (house[r + dr[2]][c + dc[2]] == 0) {
					pipe(2, r + dr[2], c + dc[2]);
				}

				if (house[r + dr[3]][c + dc[3]] == 0 && house[r + dr[3]][c + dc[3] - 1] == 0 && house[r + dr[3] - 1][c + dc[3]] == 0)
					pipe(3, r + dr[3], c + dc[3]);
				else return;
				break;
			}
		}
	}
}