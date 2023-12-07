import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[][] map;
    static int[][] ans;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        ans = new int[N][M];
        visited = new boolean[N][M];

        for(int r=0; r<N;r++){
            for(int c=0; c<M; c++){
                map[r][c] = sc.nextInt();
                if(map[r][c]==2) {
                    ans[r][c] = 0;
                    queue.add(new int[]{r,c});
                }
            }
        }
        bfs();

        for(int r=0; r<N;r++){
            for(int c=0; c<M; c++){
                if(!visited[r][c]&&map[r][c]!=0&map[r][c]!=2){
                    System.out.print(-1+" ");
                }
                else System.out.print(ans[r][c]+" ");
            }
            System.out.println();
        }
    }

    public static void bfs(){

        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];

            for(int d=0;d<4;d++){
                int idr = r+dr[d];
                int idc = c+dc[d];

                if(idr<0||idc<0||idr>=N||idc>=M) continue;
                if(visited[idr][idc]) continue;
                if(map[idr][idc]==0) continue;

                if(map[idr][idc]==1){
                    visited[idr][idc] = true;
                    ans[idr][idc] = ans[r][c]+1;
                    queue.add(new int[]{idr, idc});
                }
            }
        }
    }
}