import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N,M,K;
	static int min = -1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				if(str.charAt(j) == '#') arr[i][j] = -1;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		bfs(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1);
		
		System.out.println(min);
	}
	
	static void bfs(int sR, int sC, int eR, int eC) {
		Queue<int[]> queue = new LinkedList<>();
		arr[sR][sC] = 0;
		queue.offer(new int[] {sR,sC});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			int r = 0;
			int c = 0;
			for(int i = 0; i < 4; i++) {
				for(int j = 1; j <= K; j++) {
					r = now[0] + j*dr[i];
					c = now[1] + j*dc[i];
					if(!check(r,c) || arr[r][c] == -1) break;
					
					if(arr[r][c] == 0) {
						arr[r][c] = arr[now[0]][now[1]] + 1;
						if(r==eR && c==eC) {
							min = arr[r][c];
							return;
						}
						else queue.offer(new int[] {r,c});
					}
					else if(arr[r][c] < arr[now[0]][now[1]]+1) break;
				}
			}
	
		}
	}
	
	static boolean check(int r, int c) {
		if(r<0 || r>=N || c<0 || c>=M) return false;
		else return true;
	}
	
	static void see() {
		for(int i = 0; i< N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}