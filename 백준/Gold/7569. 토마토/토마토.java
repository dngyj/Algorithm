import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import java.util.Arrays;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;
public class Main {

    static int N, M,H, max;
    static int[][][] tomato;
    static boolean flag;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();

        tomato = new int[H + 2][M + 2][N + 2];
        flag = false;

        for(int h=0; h<H+2;h++) {
            for (int r = 0; r < M + 2; r++) {
                for (int c = 0; c < N + 2; c++) {
                    tomato[h][r][c] = -1;
                }
            }
        }

        for(int h=1; h<H+1;h++) {
            for (int r = 1; r < M + 1; r++) {
                for (int c = 1; c < N + 1; c++) {
                    tomato[h][r][c] = sc.nextInt();
                }
            }
        }
        for(int h=1; h<H+1;h++) {
            for (int r = 1; r < M + 1; r++) {
                for (int c = 1; c < N + 1; c++) {
                    if (tomato[h][r][c] == 1) {
                        queue.add(new int[]{h, r, c});
                    }
                }
            }
        }
        bfs();
        check(tomato);

        if (!flag)
            System.out.println(max-1);
        else
            System.out.println(-1);
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            int[] dot = queue.poll();

            int h = dot[0];
            int r = dot[1];
            int c = dot[2];


            // 2차원 상하좌우. 3차원 위 아래
            int[] dh = {0, 0 , 0, 0, -1, 1};
            int[] dr = { 0, 0, -1, 1, 0,0 };
            int[] dc = { -1, 1, 0, 0,0 ,0 };

            for (int i = 0; i < 6; i++) {
                int idh = h + dh[i];
                int idr = r + dr[i];
                int idc = c + dc[i];

                if (tomato[idh][idr][idc] == 0) {
                    tomato[idh][idr][idc] = tomato[h][r][c] + 1;
                    queue.add(new int[] {idh, idr, idc });
                }
            }
        }

        max = Integer.MIN_VALUE;
        for(int h=1; h<H+1;h++) {
            for (int r = 1; r < M + 1; r++) {
                for (int c = 1; c < N + 1; c++) {
                    if (tomato[h][r][c] > max) {
                        max = tomato[h][r][c];
                    }
                }
            }
        }
    }

    private static void check(int[][][] tomato) {
        for(int h=1; h<H+1;h++) {
        for (int r = 1; r < M + 1; r++) {
            for (int c = 1; c < N + 1; c++) {
                if (tomato[h][r][c] == 0) {
                    flag = true;
                }
            }
        }
        }

    }

}