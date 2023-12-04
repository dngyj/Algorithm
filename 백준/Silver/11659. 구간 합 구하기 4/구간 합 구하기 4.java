import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] dp = new int[N+1];

        int sum = 0;
        for(int i=1; i<=N;i++){
            sum = sum + sc.nextInt();
            dp[i] = sum;
        }

        for(int i = 0; i<M; i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            System.out.println(dp[ed]-dp[st-1]);
        }
    }
}