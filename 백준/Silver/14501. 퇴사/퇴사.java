import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[N+1];

        int[] day = new int[N+1];
        int[] cost = new int[N+1];
        for(int i =1;i<N+1;i++){
            day[i] = sc.nextInt();
            cost[i] = sc.nextInt();
        }
        dp[0]=0;
        for(int i=1;i<N+1;i++){
            if(i-1+day[i]<=N){
                dp[i-1+day[i]]=Math.max(dp[i-1+day[i]],dp[i-1]+cost[i]);
            }
            dp[i] = Math.max(dp[i-1],dp[i]);
        }
        System.out.println(dp[N]);
    }
}