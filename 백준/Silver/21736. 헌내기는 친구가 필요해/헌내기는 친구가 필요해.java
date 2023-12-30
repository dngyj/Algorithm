import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M, cnt;
    static char[][] map;
    static boolean[][] visited;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N][M];
        visited = new boolean[N][M];

        for(int r=0;r<N;r++){
            String str = sc.next();
            for(int c=0;c<M;c++){
                map[r][c] = str.charAt(c);
                if(map[r][c]=='I') queue.add(new int[]{r,c});
            }
        }
        cnt=0;
        bfs();
        if(cnt!=0) System.out.println(cnt);
        else System.out.println("TT");
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            visited[r][c] = true;

            if(map[r][c]=='P') cnt++;

            for(int i=0;i<4;i++){
                int idr = r+dr[i];
                int idc = c+dc[i];

                if(idr<0||idc<0||idr>=N||idc>=M) continue;
                if(visited[idr][idc]) continue;
                if(map[idr][idc]=='X') continue;

                if(map[idr][idc]=='O'||map[idr][idc]=='P'){
                    visited[idr][idc] = true;
                    queue.add(new int[]{idr,idc});
                }
            }
        }
    }

}