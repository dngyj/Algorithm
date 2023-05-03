import java.io.*;
import java.util.*;

public class Main {
	static int N,M,max;
	static char[][] arr;
	static boolean[][] visited;
	static Queue<int[]> queueGlobal = new LinkedList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && arr[i][j]=='L')bfs(i,j,true);
			}
		}
		
		while(!queueGlobal.isEmpty()) {
			int[] now = queueGlobal.poll();
			bfs(now[0],now[1],false);
		}
		
		System.out.println(max-1);
	}
	
	static void bfs(int r, int c, boolean first) {
		int[][] dist = new int[N][M];
		Queue<int[]> queue = new LinkedList<>();
		dist[r][c] = 1;
		queue.offer(new int[] {r,c});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			boolean isEdge = true;
			for(int i = 0; i < 4; i++) {
				int R = now[0] + dr[i];
				int C = now[1] + dc[i];
				if(!check(R,C))continue;
				isEdge = false;
				if(arr[R][C]=='L' && dist[R][C]==0) {
					dist[R][C] = dist[now[0]][now[1]] + 1;
					max = Math.max(dist[R][C], max);
					queue.offer(new int[] {R,C});
				}
			}
			if(first && isEdge)queueGlobal.offer(new int[] {now[0],now[1]});
		}
	}
	
	static boolean check(int r, int c) {
		if(r<0 || r>=N || c<0 || c>=M) return false;
		else return true;
	}
}