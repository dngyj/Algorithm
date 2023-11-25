import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M,cnt,max;
    static char[][] map;
    static boolean[][] visited;

    static Queue<int[]> queue = new LinkedList<>();

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];

        for(int r = 0 ; r< N ; r++){
            String str = sc.next();
            for(int c =0; c<M;c++){
                map[r][c] = str.charAt(c);
            }
        }

        max = -1;
        for(int r = 0 ; r< N ; r++){
            for(int c =0; c<M;c++){
                if(map[r][c]=='L'){
                    visited = new boolean[N][M];
                    queue.add(new int[]{r,c, 0});
                    visited[r][c] = true;
                    bfs();
                    max = Math.max(max,cnt);
                }
            }
        }

        System.out.println(max);
    }

    public static void bfs(){
        while(!queue.isEmpty()){
           int[] info = queue.poll();
           int r = info[0];
           int c = info[1];
           cnt = info[2];

           for(int i = 0; i<4; i++){
               int idr = r+dr[i];
               int idc = c+dc[i];

               if(idr<0||idc<0||idr>=N||idc>=M) continue;

               if(map[idr][idc]=='L'&&!visited[idr][idc]){
                   visited[idr][idc] = true;
                   queue.add(new int[]{idr,idc,cnt+1});
               }
           }
        }
    }
}