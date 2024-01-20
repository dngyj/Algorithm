import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int INF = 987654321;
        int[][] dp = new int[N][N];
        for(int i = 0;i<N;i++){
            Arrays.fill(dp[i],INF);
            dp[i][i] = 0;
        }
        for(int i=0;i<M;i++){
            int st = sc.nextInt()-1;
            int ed = sc.nextInt()-1;
            int cost =sc.nextInt();
            dp[st][ed] = Math.min(dp[st][ed],cost);
        }
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(dp[i][j]>dp[i][k]+dp[k][j]) dp[i][j] = dp[i][k]+dp[k][j];
                }
            }
        }
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if(dp[r][c]==INF) System.out.print(0+" ");
                else System.out.print(dp[r][c]+" ");
            }
            System.out.println();
        }
    }
}