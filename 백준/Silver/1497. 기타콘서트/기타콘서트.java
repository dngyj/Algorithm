import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br;

	static String endl = "\n";
	static String blank = " ";

	static int N;
	static int M;
	static String[][] guitar;
	static char[][] song;
	static int[] sel;
	static boolean[] isPossible;
	static int ans = 0;
	static int songMax = Integer.MIN_VALUE;
	static int guitarMin = Integer.MAX_VALUE;

	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		guitar = new String[N][2];
		song = new char[N][M];
		for (int i = 0; i < N; i++) {
			stk();
			guitar[i][0] = st.nextToken();
			guitar[i][1] = st.nextToken();
			for (int j = 0; j < M; j++) {
				song[i][j] = guitar[i][1].charAt(j);
			}
		}
	}

	static void pro() throws IOException {
		sel = new int[N];
		isPossible = new boolean[M];
		recur(0, 0);
		System.out.println(ans);
	}

	// N개의 기타, M개의 곡
	// N개의 기타 부분집합
	// cur=0, start=0
	static void recur(int cur, int start) {
		int sCnt = 0;
		int gCnt = 0;
		if (cur == N) {
			Arrays.fill(isPossible, false);
			sCnt = 0;
			gCnt = 0;
			for (int i = 0; i < N; i++) {
				// 기타를 선택했을 때 기타 개수 카운트
				if (sel[i] == 1) {
					gCnt++;
					for (int j = 0; j < M; j++) {
						// 기타가 연주할 수 있는 곡 체크
						char ch = song[i][j];
						if (ch == 'Y') isPossible[j] = true;
					}
				}
			}
			// 연주할 수 있는 곡 개수 카운트
			for (int j = 0; j < M; j++) {
				if (isPossible[j]) sCnt++;
			}
			
			if (sCnt > songMax) {
				songMax = sCnt;
				guitarMin = gCnt;
			} else if (sCnt == songMax) {
				songMax = sCnt;
				if (gCnt < guitarMin) {
					guitarMin = gCnt;
				}
			}

			if (songMax == 0) {
				ans = -1;
			} else {
				ans = guitarMin;
			}
			return;
		}
        
		sel[cur] = 1;
		recur(cur + 1, start + 1);
		sel[cur] = 0;
		recur(cur + 1, start + 1);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}