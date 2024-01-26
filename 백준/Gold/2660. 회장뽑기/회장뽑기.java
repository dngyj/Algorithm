import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int INF = 987654321;
        int[][] dp = new int[N][N];
        for(int i = 0;i<N;i++){
            Arrays.fill(dp[i],INF);
            dp[i][i] = 0;
        }
        while(true){
            int st = sc.nextInt()-1;
            int ed = sc.nextInt()-1;
            if(st==-2&&ed==-2) break;
            dp[st][ed] = 1;
            dp[ed][st] = 1;
        }
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                }
            }
        }
        int[] scores = new int[N];
        int score = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                scores[i] = Math.max(scores[i], dp[i][j]);
            }
            score = Math.min(score, scores[i]);
        }
        int cnt = 0;
        for(int i=0;i<N;i++){
           if(scores[i] == score) cnt++;
        }
        System.out.println(score+" "+cnt);
        for(int i=0;i<N;i++){
            if(scores[i] == score) System.out.print(i+1+" ");
        }
    }
}