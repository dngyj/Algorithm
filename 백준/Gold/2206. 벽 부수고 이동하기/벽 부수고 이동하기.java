import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int idr, idc;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		visited=new boolean[2][N][M];
	
		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c) - 48;
			}
		}
		
		queue.add(new int[] { 0, 0, 0,1});
		route();
	}

	private static void route() {
		
		while (!queue.isEmpty()) {
			int[] info = queue.poll();
			int r = info[0];
			int c = info[1];
			int state = info[2];
			int len = info[3];
			
			if(r==N-1&&c==M-1) {
				System.out.println(len);
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int idr = r + dr[d];
				int idc = c + dc[d];
				
	            if (idr<0 || idc<0 || idr>=N || idc>=M) continue;
	            
	            int nextLen = len+1;
	            
	           if(map[idr][idc]==0 && !visited[state][idr][idc]) {
	            	queue.add(new int[] {idr, idc, state,nextLen});
	            	visited[state][idr][idc] = true;
	            }
	           else if(map[idr][idc]==1){ // 벽일떄
	        	   if(state == 0) { // 한번도 뚫은적 없으면
	        		   queue.add(new int[] {idr, idc, 1,nextLen}); // 뚫고 표시하기
	        		   visited[1][idr][idc] = true;
	        	   }
	           }
			}
		}
		System.out.println(-1);
	}
}