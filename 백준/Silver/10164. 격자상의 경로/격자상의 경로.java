import java.util.Scanner;

public class Main {

    static int N,M;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int mark = sc.nextInt();
        dp = new int[N][M];
        if(mark == 0){
            makeMatrix(1,0,0,N,M,0);
        }
        else {
            int markRow = (mark - 1) / M;
            int markCol = (mark - 1) % M;
            makeMatrix(1,0,0,markRow+1,markCol+1,1);
        }
//        for(int r=0;r<N;r++){
//            for(int c=0;c<M;c++){
//                System.out.print(dp[r][c]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[N-1][M-1]);

    }
    static void makeMatrix(int init, int row, int col, int R, int C, int check){

            for(int r=row;r<R;r++){
                dp[r][col] = init;
            }
            for(int c=col;c<C;c++){
                dp[row][c] = init;
            }

            for(int r=row+1;r<R;r++){
                for(int c=col+1;c<C;c++){
                    dp[r][c] = dp[r-1][c]+dp[r][c-1];
                }
            }
            int nextInit = dp[R-1][C-1];
            if(check==1) makeMatrix(nextInit, R-1, C-1, N, M, 0);
    }
}