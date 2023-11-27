import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int maxWeight = sc.nextInt();

        int[][] dp = new int[N+1][maxWeight+1];
        int[] weight = new int[N+1];
        int[] value = new int[N+1];

        for(int i = 1 ; i<=N; i++){
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        for(int index = 1; index<=N;index++){
            for(int w = 1; w<=maxWeight;w++){
                dp[index][w] = dp[index-1][w];
                if(w-weight[index]>=0){
                    dp[index][w] = Math.max(dp[index][w],dp[index-1][w-weight[index]]+value[index]);
                }
            }
        }
        System.out.println(dp[N][maxWeight]);

    }

}