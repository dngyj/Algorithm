import java.util.*;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[][][] prev;

    public static void main(String[] args) {
        input();
        bfs();
    }

    static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];

            if(r==R-1&&c==C-1){
                printResult(r, c);
                return;
            }

            for(int d = 0 ; d<4; d++){
                int idr = r+dr[d];
                int idc = c+dc[d];
                if(idr<0||idc<0||idr>=R||idc>=C) continue;
                if(visited[idr][idc]) continue;
                if(map[idr][idc]=='*') continue;

                visited[idr][idc] = true;
                prev[idr][idc][0] = r;
                prev[idr][idc][1] = c;
                queue.add(new int[]{idr,idc});
            }
        }
    }

    static void printResult(int end_r, int end_c){
        ArrayList<int[]> path = new ArrayList<>();
        int r = end_r;
        int c= end_c;

        while (!(r == 0 && c == 0)) {
            path.add(new int[]{r+1, c+1});
            int prev_r = prev[r][c][0];
            int prev_c = prev[r][c][1];
            r = prev_r;
            c = prev_c;
        }
        path.add(new int[]{1,1});

        Collections.reverse(path);
        for(int[] p:path){
            System.out.println(p[0]+" "+p[1]);
        }
    }

    static void input(){
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        visited = new boolean[R][C];
        prev = new int[R][C][2];
        for(int r = 0; r<R; r++){
            String str = sc.next();
            for(int c = 0; c<C; c++){
                map[r][c] = str.charAt(c);
            }
        }
    }
}