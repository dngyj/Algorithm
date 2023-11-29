import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=0; tc<T; tc++){
            int N = sc.nextInt();

            int[][] sticker = new int[2][N];
            int[][] dp = new int[2][N];

            for(int c=0;c<N;c++){
                sticker[0][c] = sc.nextInt();
            }
            for(int c=0;c<N;c++){
                sticker[1][c] = sc.nextInt();
            }
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            int max = Math.max(dp[0][0], dp[1][0]);
            for (int i = 1; i < N; i++) {
                if (i == 1) {
                    dp[0][i] = dp[1][0] + sticker[0][1];
                    dp[1][i] = dp[0][0] + sticker[1][1];
                    max = Math.max(dp[0][i], dp[1][i]);
                    continue;
                }
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + sticker[1][i];
                max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
            }
            System.out.println(max);
        }

    }

}