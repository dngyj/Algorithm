import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int R, C, d;
    static int[][] map;
    static int cnt;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        R = sc.nextInt();
        C = sc.nextInt();
        d = sc.nextInt();

        queue.add(new int[]{R,C,d});

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = sc.nextInt();
            }
        }
        cnt = 0;
        clean();

        System.out.println(cnt);
    }

    public static void clean() {
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            int d = info[2];

            if (map[r][c] == 0) {
                map[r][c] = -1;
                cnt++;
            }
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                int idr = r + dr[i];
                int idc = c + dc[i];
                if (map[idr][idc] == 0) {
                    flag = true; // 청소할 칸이 있다면
                }
            }
            if(!flag) { //청소되지 않은 빈칸 없는 경우
                int back = d+2;
                if(back>3) back = back-4;
                int idr = r + dr[back];
                int idc = c + dc[back];
                if(map[idr][idc]!=1){
                    queue.add(new int[]{idr,idc,d});
                }
                else if(map[idr][idc] == 1){
                    return;
                }
            }
            if(flag) { //청소되지 않은 빈칸 있는 경우
                int rotateD = d - 1;
                if (rotateD < 0) rotateD = 3;
                int idr = r + dr[rotateD];
                int idc = c +dc[rotateD];
                if(map[idr][idc]==0){
                    queue.add(new int[]{idr,idc,rotateD});
                }
                else queue.add(new int[]{r, c, rotateD});
            }
        }
    }
}