import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] miro = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                miro[i][j] = sc.nextInt();
            }
        }

        int[][] dp  = new int[N][M];

        dp[0][0] = miro[0][0];

        for(int k=1;k<N;k++){
            dp[k][0] += dp[k - 1][0] + miro[k][0];
        }
        for(int k=1;k<M;k++) {
            dp[0][k] += dp[0][k-1] + miro[0][k];
        }

        for(int r=1;r<N;r++){
            for(int c=1;c<M;c++) {
                dp[r][c] = miro[r][c] + Math.max(dp[r-1][c],dp[r][c-1]);
            }
        }
        System.out.println(dp[N-1][M-1]);
    }
}