import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] dp = new int[N][3];
        int[][] cost = new int[N][3];

        for(int r=0; r<N; r++){
            for(int c=0; c<3; c++) {
                cost[r][c] = sc.nextInt();
            }
        }

        // N, color

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for(int i = 1; i<N;i++){
            dp[i][0] = Math.min(cost[i][0]+dp[i-1][1],cost[i][0]+dp[i-1][2]);
            dp[i][1] = Math.min(cost[i][1]+dp[i-1][0],cost[i][1]+dp[i-1][2]);
            dp[i][2] = Math.min(cost[i][2]+dp[i-1][0],cost[i][2]+dp[i-1][1]);
        }

        System.out.println(Math.min(Math.min(dp[N-1][0],dp[N-1][1]),dp[N-1][2]));


    }

}