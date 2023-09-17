import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] map = new int[N][3];

        for(int r=0;r<N;r++){
            for(int c=0;c<3;c++){
                map[r][c] = sc.nextInt();
            }
        }

        int[][] dp = new int[N][3];
        int[][] dpMin = new int[N][3];


        for(int c=0;c<3;c++){
           dp[0][c] = map[0][c];
           dpMin[0][c] = map[0][c];
        }

        for(int r=1;r<N;r++) {
            dp[r][0] = Math.max(dp[r-1][0], dp[r-1][1])+map[r][0];
            dp[r][1] = Math.max(Math.max(dp[r-1][0], dp[r-1][1]),dp[r-1][2])+map[r][1];
            dp[r][2] = Math.max(dp[r-1][2], dp[r-1][1])+map[r][2];

            dpMin[r][0] = Math.min(dpMin[r-1][0], dpMin[r-1][1])+map[r][0];
            dpMin[r][1] = Math.min(Math.min(dpMin[r-1][0], dpMin[r-1][1]),dpMin[r-1][2])+map[r][1];
            dpMin[r][2] = Math.min(dpMin[r-1][2], dpMin[r-1][1])+map[r][2];

        }

        System.out.print(Math.max(Math.max(dp[N-1][0], dp[N-1][1]),dp[N-1][2])+ " ");
        System.out.println(Math.min(Math.min(dpMin[N-1][0], dpMin[N-1][1]),dpMin[N-1][2]));
    }

}