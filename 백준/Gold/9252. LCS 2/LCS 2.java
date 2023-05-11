import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int len1 = str1.length();
		int len2 = str2.length();
		int[][][] dp = new int[len1+1][len2+1][4];	
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				 
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					// 대각선 위 (i-1, j-1)의 dp에 +1 한 값으로 갱신 
					dp[i][j][0] = dp[i - 1][j - 1][0] + 1;
					dp[i][j][1] = i - 1;
					dp[i][j][2] = j - 1;
					dp[i][j][3] = str1.charAt(i-1);
				}
						
				// 같지 않다면 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신  
				else {
					if(dp[i - 1][j][0] > dp[i][j - 1][0]) {
						dp[i][j][0] = dp[i - 1][j][0];
						dp[i][j][1] = dp[i - 1][j][1];
						dp[i][j][2] = dp[i - 1][j][2];
						dp[i][j][3] = dp[i - 1][j][3];
					}
					else {
						dp[i][j][0] = dp[i][j - 1][0];
						dp[i][j][1] = dp[i][j - 1][1];
						dp[i][j][2] = dp[i][j - 1][2];
						dp[i][j][3] = dp[i][j - 1][3];
					}
				}
			}
		}
		/*for(int i = 0; i <= len1; i++) {
			for(int j = 0; j <= len2; j++) {
				System.out.print(Arrays.toString(dp[i][j])+"  ");
			}
			System.out.println();
		}*/
		
		
		StringBuilder sb = new StringBuilder();
		System.out.println(dp[len1][len2][0]);
		if(dp[len1][len2][0] != 0) {
		int r = len1;
		int c = len2;
		while(true) {
			//System.out.println(Arrays.toString(dp[r][c]));
			sb.append((char)dp[r][c][3]);
			int a = dp[r][c][1];
			int b = dp[r][c][2];
			r = a;
			c = b;
			if(dp[r][c][3]==0) break;
		}
		System.out.println(sb.reverse());
	}
	}
	
}