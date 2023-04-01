import java.util.Scanner;

public class Main {

	static int N, cnt, max;
	static int[][] area;
	static int[][] safe;
	static boolean[][] visited;
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		area = new int[N+2][N+2];
		
		for(int r = 1; r<N+1;r++) {
			for(int c = 1; c<N+1; c++) {
				area[r][c] = sc.nextInt();
			}
		}
		int max =0;
		for(int k = 0; k<=100;k++) {
			visited =new boolean[N+2][N+2];
			cnt = 0;
			for(int r = 0; r<N+2;r++) {
				for(int c = 0; c<N+2; c++) {
					if(area[r][c]>k&&!visited[r][c]) {
					cnt +=dfs(r,c,k);
					}
				}
			}
			max =Math.max(max, cnt);
		}
		System.out.println(max);
	}
	
	private static int dfs(int r, int c,int k) {
		// 좌 우 위 아
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };
		visited[r][c] = true;
		
			for (int i = 0; i < 4; i++) {
				int idr = r + dr[i];
				int idc = c + dc[i];

				if (area[idr][idc]-k > 0 && !visited[idr][idc]) {
					visited[idr][idc] = true;
					dfs(idr, idc,k);
				}
			}
		return 1;
	}

}