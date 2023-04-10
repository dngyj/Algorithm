import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		// 1 뺄 때// 2나눌때 // 3나눌때
		
		int[] dp = new int[X + 1];
		dp[1] = 0; // 굳이 안해도 됨.

		for (int i = 2; i <= X; i++) {
			int min = 987654321;
			min = Math.min(min, dp[i - 1] + 1);
			if (i %2==0)
				min = Math.min(min, dp[i/2] + 1);
			if (i %3==0)
				min = Math.min(min, dp[i/3] + 1);
			dp[i] = min;
		}

		System.out.println(dp[X]);
	}
}