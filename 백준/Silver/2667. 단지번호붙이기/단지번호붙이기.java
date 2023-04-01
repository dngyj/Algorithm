import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static char[][] map;
	static int[][] nmap;
	static boolean[][] visited;
	static int N;
	static int cnt;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 지도 크기

		map = new char[N][N];
		nmap = new int[N + 2][N + 2];
		visited = new boolean[N + 2][N + 2];

		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		for (int r = 1; r < N + 1; r++) {
			for (int c = 1; c < N + 1; c++) {
				nmap[r][c] = map[r - 1][c - 1] - 48;
			}
		}

		for (int r = 0; r < N + 2; r++) {
			for (int c = 0; c < N + 2; c++) {
				if (!visited[r][c] && nmap[r][c] == 1) {
					cnt = 0;
					bfs(r, c);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int l : list) {
				System.out.println(l);
		}
	}

	private static void bfs(int r, int c) {
		// 좌 우 위 아
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };
		visited[r][c] = true;
		cnt++;
		
		if (r == N + 1 && c == N + 1)
			return;

		else {
			for (int i = 0; i < 4; i++) {
				int idr = r + dr[i];
				int idc = c + dc[i];

				if (nmap[idr][idc] == 1 && !visited[idr][idc]) {
					visited[idr][idc] = true;
					bfs(idr, idc);
				}
			}
		}
	}
}