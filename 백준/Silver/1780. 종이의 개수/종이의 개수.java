import java.util.Scanner;

public class Main {

	static int[][] paper;
	static int N;
	static int cnt1, cnt2, cnt3;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		paper = new int[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				paper[r][c] = sc.nextInt();
			}
		}
		
		cnt1=cnt2=cnt3=0;
		
		cut(N, 0, 0);
		
		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);

	}
	
	private static void cut(int N,int r, int c) {
		if(!numcheck(N, r, c)) {
			if(paper[r][c]==-1) {
				cnt1++;
			}
			else if(paper[r][c]==0) {
				cnt2++;
			}
			else
				cnt3++;
			return;
		}
	
	N = N/3;

	cut(N, r, c);								// 왼쪽 위
	cut(N, r, c+N);						// 중앙 위
	cut(N, r, c + 2 * N);					// 오른쪽 위
	
	cut(N, r + N, c);						// 왼쪽 중간
	cut(N,r + N, c + N);			// 중앙 중간
	cut(N,r + N, c + 2 * N);		// 오른쪽 중간
	
	cut(N,r + 2 * N, c);					// 왼쪽 아래
	cut(N,r + 2 * N, c + N);		// 중앙 아래
	cut(N,r + 2 * N, c + 2 * N);	// 오른쪽 아래
	
	}

	private static boolean numcheck(int N, int r, int c) {
		int num = paper[r][c];
		
		for(int i=r;i<r+N;i++) {
			for(int j=c;j<c+N;j++) {
				if(num != paper[i][j])
					return true;
			}
		}
		return false;
	}
}