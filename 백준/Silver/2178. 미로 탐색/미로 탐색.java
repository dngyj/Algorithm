import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] maze;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt;
	static int idr, idc;
	static int min = Integer.MAX_VALUE;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		maze = new int[N + 2][M + 2];
		visited = new boolean[N + 2][M + 2];

		for (int r = 0; r < N + 2; r++) {
			for (int c = 0; c < M + 2; c++) {
				maze[r][c] = 0;
			}
		}

		for (int r = 1; r < N + 1; r++) {
			String str = sc.next();
			for (int c = 0; c < M; c++) {
				maze[r][c + 1] = str.charAt(c) - 48;
			}
		}
		queue.add(new int[] {1, 1});
		cnt=0;
		find();
		System.out.println(maze[N][M]);
	}

	private static void find() {
		
		while(!queue.isEmpty()) {
			int[] loc = queue.poll();
			int r = loc[0];
			int c = loc[1];
			
			for (int d = 0; d < 4; d++) {
				int idr = r+dr[d];
				int idc = c+dc[d];
				
				if(maze[idr][idc]==1) {
					maze[idr][idc]=maze[r][c]+1;
					queue.add(new int[] {idr, idc});
				}
			}
		}
	}

}