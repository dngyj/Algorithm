import java.util.Scanner;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int result;
	static int w;
	static int h;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		boolean flag = true;
		while (flag) {
			w = sc.nextInt(); // 지도 너비
			h = sc.nextInt(); // 지도 높이

			if (w == 0 && h == 0) {
				flag = false;
				break;
			}
			map = new int[h + 2][w + 2];
			visited = new boolean[h + 2][w + 2];
			for (int r = 1; r <= h; r++) {
				for (int c = 1; c <= w; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			result = 0;
			outer: for (int r = 1; r <= h; r++) {
				for (int c = 1; c <= w; c++) {
					if (r == h+1 && c == w+1) {
						break outer;
					}
					if (!visited[r][c] && map[r][c] == 1) {
						result++;
						bfs(r, c);
					}
				}
			}
			System.out.println(result);
		}
	}

	private static void bfs(int r, int c) {
		// 좌 우 위 아 대각1 대각2,대각 3, 대각4
		
		int[] dr = { 0, 0, -1, 1, 1, 1, -1,-1 };
		int[] dc = { -1, 1, 0, 0, 1, -1,1,-1};
		
		if (r == h+1 && c == w+1)
			return;

		else {
			for (int i = 0; i < 8; i++) {
				if (map[r + dr[i]][c + dc[i]] == 1&&!visited[r + dr[i]][c + dc[i]]) {
					visited[r + dr[i]][c + dc[i]] = true;
					int idr = r + dr[i];
					int idc = c + dc[i];
					bfs(idr, idc);
				}
			}
		}
	}

}