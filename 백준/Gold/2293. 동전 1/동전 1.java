import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] dp = new int[K+1];
        int[] coins = new int[N];

        for(int i = 0;i<N;i++){
            int coin = sc.nextInt();
           coins[i] = coin;
        }
        dp[0] = 1;
        for(int i = 0; i<N;i++){
            for(int j = 1;j<=K;j++){
                if(j>=coins[i]) dp[j] += dp[j-coins[i]];
            }
        }
        System.out.println(dp[K]);
    }
}