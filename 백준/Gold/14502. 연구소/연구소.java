import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static int cnt, ans;

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];


        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                map[r][c] = sc.nextInt();
            }
        }
        bfs(0);

        System.out.println(ans);
    }

    private static void bfs(int depth) {
        if(depth==3){
            virus();
            return;
        }
        for(int r=0; r<N;r++){
            for(int c=0;c<M;c++){
                if(map[r][c]==0) {
                    map[r][c] = 1;
                    bfs(depth + 1);
                    map[r][c] = 0;
                }
            }
        }
    }

    private static void virus() {
        int[][] cloneMap = new int[N][M];
        visited = new boolean[N][M];
        for(int r=0;r<N;r++){
            for(int c=0; c<M; c++){
                cloneMap[r][c] = map[r][c];
                if(map[r][c]==2){
                    queue.add(new int[]{r, c});
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];

            visited[r][c] = true;

            for (int i = 0; i < 4; i++) {
                int idr = r + dr[i];
                int idc = c + dc[i];

                if(idr<0||idr>=N||idc<0||idc>=M) continue;
                if(visited[idr][idc]) continue;

                if (cloneMap[idr][idc] == 0) {
                    cloneMap[idr][idc] = 2;
                    queue.add(new int[]{idr, idc});
                }
            }
        }
        cnt=0;
        count(cloneMap);
        ans = Math.max(cnt, ans);
    }

    private static void count(int[][] cloneMap){
        for(int r=0;r<N;r++){
            for(int c=0; c<M; c++){
                if(cloneMap[r][c]==0){
                    cnt++;
                }
            }
        }
    }
}