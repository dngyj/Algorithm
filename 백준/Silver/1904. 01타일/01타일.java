import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		
		Scanner s= new Scanner(System.in);
		
		int N = s.nextInt();
		int dp[] = new int[N+1];
		
		dp[0]=1; 
		dp[1]=1;
		
		if(N>=2) {
			for(int i=2;i<=N;i++) {
				dp[i]=(dp[i-1] + dp[i-2])% 15746;
			}
		}
		
		System.out.println(dp[N]);
	}
}