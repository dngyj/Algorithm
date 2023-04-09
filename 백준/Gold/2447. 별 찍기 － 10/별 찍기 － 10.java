import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static String[][] star;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		
		star = new String[N][N]; // 결과 저장할 배열
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				pattern(r, c, N);   // 전체 N까지 돌면서 각각 하나의 원소마다 패턴 재귀를 돌린다
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sb.append(star[r][c]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	private static void pattern(int r, int c, int N) {  
		
		if((r/N)%3==1&&(c/N)%3==1) {  // 3*3배열에서 비어야하는 값은 가운데 (1,1) 좌표인곳. 
			star[r][c] =" ";
		}
		
		else {
			if(N==1) star[r][c] = "*";
			else pattern(r, c, N/3);
		}

	
	}
}