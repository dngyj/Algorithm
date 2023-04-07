import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br;

	static String endl = "\n";
	static String blank = " ";
	static int N, M;
	static int ans;
	static boolean flag;
	static int[] key;
	static char[][] map;
	static boolean[][][][][][][][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// . : 빈칸, # : 벽, a~f : 열쇠, A~F : 문, 0 : 민식, 1 : 출구
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		key = new int[6];
		visited = new boolean[2][2][2][2][2][2][N][M];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c);
			}
		}
	}

	static void pro() throws IOException {
		ans = Integer.MAX_VALUE;
		Outer: for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == '0') {
					bfs(r, c);
					if (flag) {
						System.out.println(ans);
					} else {
						System.out.println(-1);
					}
					break Outer;
				}
			}
		}
	}

	static void bfs(int x, int y) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(x, y, 0, new int[6]));
		visited[0][0][0][0][0][0][x][y] = true;
		int temp = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			// 도착 지점
			if (map[p.r][p.c] == '1') {
				flag = true;
				ans = Math.min(ans, p.move);
				break;
			}
			int[] nKey = p.key;
			int a = p.key[0];
			int b = p.key[1];
			int c = p.key[2];
			int d = p.key[3];
			int e = p.key[4];
			int f = p.key[5];
			int move = p.move;
			int nr, nc;
			for (int i = 0; i < 4; i++) {
				nr = p.r + dr[i];
				nc = p.c + dc[i];
				if (!inRange(nr, nc) || map[nr][nc] == '#') continue;
				char ch = map[nr][nc];
				if ('A' <= ch && ch <= 'F') {
					if (visited[a][b][c][d][e][f][nr][nc]) continue;
					// 열쇠 있어? 있으면 열고 가
					if (nKey[ch - 'A'] != 0) {
						q.offer(new Point(nr, nc, move + 1, nKey));
						visited[a][b][c][d][e][f][nr][nc] = true;
					}
					// 없으면 못가
				}
				// 탐색하는데 열쇠가 있어 => 줍줍
				else if ('a' <= ch && ch <= 'f') {
					if (visited[a][b][c][d][e][f][nr][nc]) continue;
					int[] key = new int[6];
					for (int j = 0; j < key.length; j++) {
						key[j] = nKey[j];
					}
					key[ch - 'a'] = 1;
					q.offer(new Point(nr, nc, move + 1, key));
					visited[key[0]][key[1]][key[2]][key[3]][key[4]][key[5]][nr][nc] = true;
				} else {
					if (visited[a][b][c][d][e][f][nr][nc]) continue;
					q.offer(new Point(nr, nc, move + 1, nKey));
					visited[a][b][c][d][e][f][nr][nc] = true;
				}
			}
		}
	}

	static boolean inRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}

	static class Point {
		int r, c, move;
		int[] key;

		public Point(int r, int c, int move, int[] key) {
			super();
			this.r = r;
			this.c = c;
			this.move = move;
			this.key = key;
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