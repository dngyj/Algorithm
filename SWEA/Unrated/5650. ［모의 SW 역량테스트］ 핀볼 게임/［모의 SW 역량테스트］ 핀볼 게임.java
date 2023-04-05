import java.util.Scanner;

public class Solution {
	
	static int N, cnt;
	static int[][] map;
	static int idr, idc;
	static int str, stc;
	static int[][] shape = { 
			{ 1, 3, 0, 2 },
			{ 3, 0, 1, 2 },
			{ 2, 0, 3, 1 },
			{ 1, 2, 3, 0 }, 
			{ 1, 0, 3, 2 } 
		};
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N + 2][N + 2];

			for (int i = 0; i < N + 2; i++) {
				map[0][i] = map[i][0] = map[i][N + 1] = map[N + 1][i] = 5;
			}

			for (int r = 1; r < N + 1; r++) {
				for (int c = 1; c < N + 1; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			int result = Integer.MIN_VALUE;
			
			for (int r = 1; r < N + 1; r++) {
				for (int c = 1; c < N + 1; c++) {
					if (map[r][c] == 0) {
						str = r;
						stc =c;
						for (int d = 0; d < 4; d++) {
							cnt = 0;
							move(d, r, c);
							if (cnt > result)
								result = cnt;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void move(int d, int r, int c) {
	
		idr = r;
		idc = c;

		while(true) {
			idr = idr+dr[d];
			idc = idc + dc[d];
			
			if (map[idr][idc] == -1)
				break;
				
			if (idr == str && idc == stc)
				break;
			
			if (map[idr][idc] >= 6 && map[idr][idc] <= 10) {
				int[] hole = wormhole(map[idr][idc],idr, idc);
				idr = hole[0];
				idc= hole[1];
			}
			
			if (map[idr][idc] >= 1 && map[idr][idc] <= 5) {
				cnt++;
				d = shape[map[idr][idc]-1][d];
			}
		}
	}

	private static int[] wormhole(int num, int idr, int idc) {
		int[] result = new int[2];
		for (int r = 1; r < N + 1; r++) {
			for (int c = 1; c < N + 1; c++) {
				if (map[r][c]==num && (idr != r || idc != c)) {
					result[0] = r;
					result[1] = c;
				}
			}
		}
		return result;
	}
}