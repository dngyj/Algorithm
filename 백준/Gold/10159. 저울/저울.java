import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] dp = new int[N][N];
        for(int i =0;i<N;i++){
            dp[i][i] = 0;
        }
        for(int i =0;i<M;i++){
            int st = sc.nextInt()-1;
            int ed = sc.nextInt()-1;
            dp[st][ed] = 1;
            dp[ed][st] = -1;
        }
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(dp[i][k]==1&&dp[k][j]==1) dp[i][j] = 1;
                    if(dp[i][k]==-1&&dp[k][j]==-1) dp[i][j] = -1;
                }
            }
        }
        for(int i=0;i<N;i++){
            int cnt = 0;
            for(int j=0;j<N;j++){
               if(i!=j&&dp[i][j]==0) cnt++;
            }
            System.out.println(cnt);
        }
    }
}