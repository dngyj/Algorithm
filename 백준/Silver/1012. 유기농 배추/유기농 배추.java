import java.util.Scanner;

public class Main {

    static int N,M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int k=1;k<=K;k++){
                int r = sc.nextInt();
                int c = sc.nextInt();
                map[r][c] = 1;
            }

            int cnt = 0;

            for(int r=0; r<N;r++){
                for(int c=0; c<M; c++){
                    if(!visited[r][c]&&map[r][c]==1){
                        earthworm(r,c);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }

    }

    private static void earthworm(int r, int c) {

        visited[r][c] = true;

        for(int d=0; d<4;d++) {
            int idr = r + dr[d];
            int idc = c + dc[d];

            if(idr<0||idc<0||idr>=N||idc>=M){
                continue;
            }

            if(map[idr][idc]==1&&!visited[idr][idc]){
                visited[idr][idc] = true;
                earthworm(idr, idc);
            }
        }

    }

}