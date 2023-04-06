import java.util.*;
import java.io.*;

public class Main {


	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br;

	static String endl = "\n";
	static String blank = " ";

	static int N, M;
	static int[][] board;
	static boolean[][] visited;
	static boolean[][] wall;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int ans = Integer.MAX_VALUE;
	static boolean flag = false;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];
		wall = new boolean[N][M];
		String str;
		for (int r = 0; r < N; r++) {
			str = br.readLine();
			for (int c = 0; c < M; c++) {
				board[r][c] = str.charAt(c) - '0';
			}
		}
	}

	static void pro() throws IOException {
		bfs(0, 0);
		if (flag) {
			System.out.println(ans);
		}
		else System.out.println(-1);
	}
	
	static void bfs(int r, int c) {
		Queue<Node> q = new ArrayDeque<Node>();
		visited[r][c] = true;
		q.offer(new Node(r, c, 1, false));
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.r == N-1 && n.c == M-1) {
				flag = true;
				ans = Math.min(ans, n.cnt);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				int cnt = n.cnt;
				// bl = 벽을 부순 상태를 나타냄
				boolean bl = n.bl;
				// 벽을 부셨으면 벽 만나면 못 가
				// 벽 안부셨으면 벽 만나면 부수고 가
				if (bl) {
					if (!inRange(nr, nc) || wall[nr][nc] || board[nr][nc] == 1) continue;
					q.offer(new Node(nr, nc, cnt + 1, true));
					wall[nr][nc] = true;
				}
				else { 
					if (!inRange(nr, nc) || visited[nr][nc]) continue;
					if (board[nr][nc] == 1) {
						q.offer(new Node(nr, nc, cnt+1, true));
						wall[nr][nc] = true;
					}
					else {
						q.offer(new Node(nr, nc, cnt+1, false));
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
	
	static boolean inRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
	
	static class Node {
		int r, c, cnt;
		boolean bl;
		public Node(int r, int c, int cnt, boolean bl) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.bl = bl;
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