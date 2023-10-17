import java.util.*;

public class Main {

    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static int ans;

    static ArrayList<pos> list = new ArrayList<>();
    static pos[] route;

    static class pos{
        int r, c;
        public pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        route = new pos[M];

        for(int r = 0; r<N;r++){
            for(int c =0; c<N;c++){
                map[r][c] = sc.nextInt();
                if(map[r][c]==2) list.add(new pos(r,c));
            }
        }

        ans = Integer.MAX_VALUE;
        bfs(0, 0);
        if(ans==Integer.MAX_VALUE){
            ans = -1;
        }
        System.out.println(ans);

    }

    private static void bfs(int depth, int idx) {
//        System.out.println("bfs진입");
        if(depth==M){
            virus();
            return;
        }
        for(int i = idx; i<list.size();i++){
            route[depth] = list.get(i);
            bfs(depth+1, i+1);
        }
    }

    private static void virus() {
        Queue<pos> queue = new LinkedList<>();
        visited = new boolean[N][N];
        int result = 0;

        for(int i=0;i<M;i++){
            visited[route[i].r][route[i].c] = true;
            queue.add(route[i]);
        }
        while(!queue.isEmpty()){
            if(result>=ans) return;

            int size = queue.size();

            for(int k = 0; k<size;k++) {
                pos info = queue.poll();
                int r = info.r;
                int c = info.c;

                for (int i = 0; i < 4; i++) {
                    int idr = r + dr[i];
                    int idc = c + dc[i];

                    if (idr < 0 || idc < 0 || idr >= N || idc >= N) continue;

                    if (visited[idr][idc]) continue;

                    if (map[idr][idc] == 1) continue;

                    queue.add(new pos(idr, idc));
                    visited[idr][idc] = true;
                }
            }
            result++;
        }
        if(mapCheck(visited)) ans = Math.min(ans,result-1);

    }

    static boolean mapCheck(boolean[][] visited){
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if(map[r][c] != 1 && !visited[r][c])
                    return false;
            }
        }
        return true;
    }

}