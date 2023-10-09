import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    static int[] dr = {1,-1,0,0,1,1,2,2,-1,-1,-2,-2};
    static int[] dc = {0,0,1,-1,2,-2,1,-1,2,-2,1,-1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();
        map = new int[H][W];
        visited = new boolean[H][W][K+1];

        for(int r=0;r<H;r++){
            for(int c=0; c<W;c++){
                map[r][c] = sc.nextInt();
            }
        }
        queue.add(new int[]{0, 0, K,0});
        bfs();
    }

    private static void bfs() {

        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            int state = info[2];
            int depth = info[3];


            if (r < 0 || r >= H || c < 0 || c >= W) continue;
            if(map[r][c]==1) continue;
            if(visited[r][c][state]) continue;

            visited[r][c][state] = true;

            if(r==H-1&&c==W-1) {
                System.out.println(depth);
                return;
            }

            for(int i=0;i<4;i++) {
                int idr = r + dr[i];
                int idc = c + dc[i];
                queue.add(new int[]{idr, idc, state, depth+1});
            }
            if(state>0) {
                for (int i=4;i<12;i++){
                    int idr = r + dr[i];
                    int idc = c + dc[i];
                    queue.add(new int[]{idr, idc, state-1, depth+1});
                }
            }
        }
        System.out.println(-1);
    }
}