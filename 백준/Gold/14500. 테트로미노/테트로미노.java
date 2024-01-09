import java.util.Scanner;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int tetro;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int r = 0; r<N; r++){
            for(int c = 0; c<M;c++){
                map[r][c] = sc.nextInt();
            }
        }
        tetro = Integer.MIN_VALUE;
        for(int r = 0; r<N; r++){
            for(int c = 0; c<M;c++){
                visited[r][c] = true;
                dfs(r,c,map[r][c],1);
                visited[r][c] = false;
            }
        }
        System.out.println(tetro);
    }

    static void dfs(int r, int c,int sum, int depth){
        if(depth==4) {
            tetro = Math.max(sum, tetro);
            return;
        }
        for(int i = 0; i<4; i++){
            int idr = r+dr[i];
            int idc = c+dc[i];

            if(idr<0||idc<0||idr>=N||idc>=M) continue;
            if(visited[idr][idc]) continue;

            if(depth==2){
                visited[idr][idc] = true;
                dfs(r,c,sum+map[idr][idc],depth+1);
                visited[idr][idc] = false;
            }
            visited[idr][idc] = true;
            dfs(idr,idc,sum+map[idr][idc],depth+1);
            visited[idr][idc] = false;
        }
    }
}