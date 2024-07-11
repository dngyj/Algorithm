import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M,K;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int ans = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M][K+1];
        for(int r=0;r<N;r++) {
            String s = sc.next();
            for (int c = 0; c < M; c++) {
                map[r][c] = s.charAt(c) - 48;
            }
        }
        bfs();

        System.out.println(ans);
    }
    static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,0,1,1});
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            int crash = info[2];
            int day = info[3];
            int cnt = info[4];
//            System.out.println("d"+day);
//            System.out.println(r+" "+c+" c"+crash);
            if(r==N-1&&c==M-1){
                ans = cnt;
                return;
            }

            for(int d=0;d<4;d++){
                int idr = r+dr[d];
                int idc = c+dc[d];
                if(idr<0||idc<0||idr>=N||idc>=M) continue;

                if(map[idr][idc]==0){
                    if(!visited[idr][idc][crash]) {
                        visited[idr][idc][crash] = true;
                        queue.add(new int[]{idr, idc, crash,day*-1, cnt+1});
                    }
                }
                else {
                    if(crash<K&&day==1) {
                        if (!visited[idr][idc][crash + 1]) {
                            visited[idr][idc][crash + 1] = true;
                            queue.add(new int[]{idr, idc, crash+1, day*-1, cnt+1});
                        }
                    }
                    else if(crash<K&&day==-1){
                        queue.add(new int[]{r,c,crash, day*-1, cnt+1});
                    }
                }
            }
        }
    }
}