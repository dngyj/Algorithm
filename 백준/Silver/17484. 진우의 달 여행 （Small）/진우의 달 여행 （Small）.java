import java.util.Scanner;

public class Main {
    static int[][] map;
    static int N,M;
    static int[] dc = {-1,0,1};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        for(int r = 0;r<N;r++){
            for(int c = 0; c<M;c++){
                map[r][c] = sc.nextInt();
            }
        }
        for(int c = 0; c<M;c++){
            dfs(0,c,-1,map[0][c]);
        }
        System.out.println(min);
    }

    static void dfs(int r, int c, int preD, int cost){
        if(r==N-1){
            min = Math.min(min,cost);
        }
        else{
            for(int i = 0;i<3;i++){
                if(preD==i) continue;
                int idr = r+1;
                int idc = c+dc[i];
                if(idc<0||idc>=M) continue;
                dfs(idr,idc,i,cost+map[idr][idc]);
            }
        }
    }
}