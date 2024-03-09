import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int max, area;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int r = 0; r<N;r++){
            for(int c = 0; c<M;c++){
                map[r][c] = sc.nextInt();
            }
        }
        int cnt = 0;
        max = 0;
        for(int r = 0; r<N;r++){
            for(int c = 0; c<M;c++){
                if(!visited[r][c]&&map[r][c]==1){
                    area = 0;
                    bfs(r,c);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);

    }
    static void bfs(int row, int col){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            area++;
            visited[r][c] = true;
            for(int d=0;d<4;d++){
                int idr = r+dr[d];
                int idc = c+dc[d];
                if(idr<0||idc<0||idr>=N||idc>=M) continue;
                if(visited[idr][idc]) continue;
                if(map[idr][idc]==1) {
                    visited[idr][idc] = true;
                    queue.add(new int[]{idr,idc});
                }
            }
        }
        max = Math.max(max, area);
    }
}