import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M,K;
    static char[][] map;
    static int[][] visited;
    static int r1,r2,c1,c2;
    static int cnt;
    static boolean[] cantgo;

    static Queue<int[]> queue = new LinkedList<>();

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        map = new char[N][M];
        visited = new int[N][M];

        for(int r = 0; r<N;r++){
            String str = sc.next();
            Arrays.fill(visited[r], Integer.MAX_VALUE);
            for(int c = 0; c<M; c++){
                map[r][c] = str.charAt(c);
            }
        }
        r1 = sc.nextInt()-1;
        c1 = sc.nextInt()-1;
        r2 = sc.nextInt()-1;
        c2 = sc.nextInt()-1;

        queue.add(new int[]{r1,c1, 0});
        visited[r1][c1] = 0;
        bfs();

    }
    public static void bfs(){

        while(!queue.isEmpty()){
            cantgo = new boolean[4];
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            int cnt = info[2];

            if(r==r2&&c==c2){
                System.out.println(cnt);
                return;
            }
            for(int d=0;d<4;d++){
                 for(int k=1; k<=K;k++){
                    if(cantgo[d]) continue;
                    int idr = r+dr[d]*k;
                    int idc = c+dc[d]*k;

                    if(idr<0||idc<0||idr>=N||idc>=M) continue;
                    if(map[idr][idc]=='#') {
                        cantgo[d] = true;
                        continue;
                    }
                    if(visited[idr][idc]<visited[r][c]+1) break;
                    if(map[idr][idc]=='.'&&visited[idr][idc]==Integer.MAX_VALUE){
                        visited[idr][idc] = visited[r][c]+1;
                        queue.add(new int[]{idr,idc, cnt+1});
                    }
                }
            }
        }
        System.out.println(-1);
    }
}