import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, max;
	static int[][] tomato;
	static boolean flag;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		tomato = new int[M + 2][N + 2];
		flag = false;

		for (int r = 0; r < M + 2; r++) {
			Arrays.fill(tomato[r], -1);
		}

		for (int r = 1; r < M + 1; r++) {
			for (int c = 1; c < N + 1; c++) {
				tomato[r][c] = sc.nextInt();
			}
		}

		for (int r = 1; r < M + 1; r++) {
			for (int c = 1; c < N + 1; c++) {
				if (tomato[r][c] == 1) {
					queue.add(new int[] { r, c });
				}
			}
		}

		bfs();
		check(tomato);

		if (!flag)
			System.out.println(max-1);
		else
			System.out.println(-1);
	}

	private static void bfs() {

		while (!queue.isEmpty()) {
			int[] dot = queue.poll();
			int r = dot[0];
			int c = dot[1];
			
			int[] dr = { 0, 0, -1, 1 };
			int[] dc = { -1, 1, 0, 0 };

			for (int i = 0; i < 4; i++) {
				int idr = r + dr[i];
				int idc = c + dc[i];

				if (tomato[idr][idc] == 0) {
					tomato[idr][idc] = tomato[r][c] + 1;
					queue.add(new int[] { idr, idc });
				}
			}
		}

		max = Integer.MIN_VALUE;
		for (int r = 1; r < M + 1; r++) {
			for (int c = 1; c < N + 1; c++) {
				if (tomato[r][c] > max) {
					max = tomato[r][c];
				}
			}
		}
	}

	private static void check(int[][] tomato) {
		for (int r = 1; r < M + 1; r++) {
			for (int c = 1; c < N + 1; c++) {
				if (tomato[r][c] == 0) {
					flag = true;
				}
			}
		}
	}

}