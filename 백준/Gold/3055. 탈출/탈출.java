import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N,M;
    static char[][] map;
    static int[][] time;
    static boolean[][] visited;
    static boolean[][] visited1;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static  Queue<int[]> queue = new LinkedList<>();
    static  Queue<int[]> waters = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        visited = new boolean[N][M];
        visited1 = new boolean[N][M];
        time = new int[N][M];

        for(int r=0;r<N;r++){
            String str = sc.next();
            for(int c=0;c<M;c++){
                time[r][c] = 2500;
                map[r][c] = str.charAt(c);
                if(map[r][c] == 'S'){
                    queue.add(new int[]{r,c,1});
                    visited[r][c] = true;
                }
                if(map[r][c]=='*'){
                    waters.add(new int[]{r,c,1});
                    time[r][c] = -1;
                }
            }
        }
        waterCheck();
        int ans = bfs();

        if(ans==-1) System.out.println("KAKTUS");
        else System.out.println(ans-1);
    }
    static int bfs(){
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            int depth = info[2];

            if(map[r][c]=='D'){
                return depth;
            }
            for(int i = 0; i<4;i++){
                int idr = r+dr[i];
                int idc = c+dc[i];
                if(idr<0||idc<0||idr>=N||idc>=M) continue;
                if(visited[idr][idc]) continue;
                if(map[idr][idc]=='*'||map[idr][idc]=='X') continue;
                if(depth<time[idr][idc]) {
                   visited[idr][idc] = true;
                    queue.add(new int[]{idr, idc, depth + 1});
                }
            }
        }
        return -1;
    }
    static void waterCheck(){
        while(!waters.isEmpty()){
            int[] info = waters.poll();
            int r = info[0];
            int c = info[1];
            int depth = info[2];
            for(int i = 0; i<4;i++){
                int idr = r+dr[i];
                int idc = c+dc[i];
                if(idr<0||idc<0||idr>=N||idc>=M) continue;
                if(visited1[idr][idc]) continue;
                if(map[idr][idc]=='D'||map[idr][idc]=='X') continue;
                if(map[idr][idc]=='.'||map[idr][idc]=='S'){
                    visited1[idr][idc] = true;
                    time[idr][idc] = depth;
                    waters.add(new int[]{idr,idc,depth+1});
                }
            }
        }
    }
}