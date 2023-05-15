import java.util.Scanner;

public class Main {

    static int M, N;
    static boolean flag;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int r = 0; r < M; r++) {
            String str = sc.next();
            for (int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c) - 48;
            }
        }


        for (int c = 0; c < N; c++) {
            if (map[0][c] == 0) {
                dfs(0, c);
            }
        }


        if (flag) System.out.println("YES");
        else System.out.println("NO");

    }

    public static void dfs(int r, int c) {
        if (r == M - 1) {
            flag = true;
        } else {
            for (int d = 0; d < 4; d++) {
                int idr = r + dr[d];
                int idc = c + dc[d];

                if (idr < 0 || idc < 0 || idr >= M || idc >= N) continue;

                if (map[idr][idc] == 0 && !visited[idr][idc]) {
                    visited[idr][idc] = true;
                    dfs(idr, idc);
                }

            }

        }

    }
}