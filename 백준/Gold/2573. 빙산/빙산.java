import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[][] map;
    static int[][] decrease;
    static boolean[][] visited;
    static int year;
    static boolean isIce;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for(int r=0;r<N;r++){
            for(int c=0;c<M;c++){
                map[r][c] = sc.nextInt();
            }
        }
        isIce = false;
        year = 0;
        melt();
        if(!isIce) System.out.println(0);
        else System.out.println(year);
    }
    static void melt(){
        while(true) {
            addIce();
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if(map[r][c] - decrease[r][c] <0) map[r][c] =0;
                    else map[r][c] = map[r][c] - decrease[r][c];
                }
            }
            visited = new boolean[N][M];
            int block = 0;
            isIce = false;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] != 0 && !visited[r][c]) {
                        bfs(r, c);
                        visited[r][c] = true;
                        block++;
                        isIce = true;
                    }
                }
            }
            year++;
            if (block >= 2) break;
            if(!isIce) break;
        }
    }
    static void addIce(){
        Queue<int[]> ice = new LinkedList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] != 0) ice.add(new int[]{r, c});
            }
        }
        decrease = new int[N][M];
        while (!ice.isEmpty()) {
            int[] info = ice.poll();
            int r = info[0];
            int c = info[1];
            for (int i = 0; i < 4; i++) {
                int idr = r + dr[i];
                int idc = c + dc[i];
                if (map[idr][idc] == 0) decrease[r][c]++;
            }

        }
    }
    static void bfs(int row, int col){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            visited[r][c] = true;
            for(int i=0;i<4;i++){
                int idr = r+dr[i];
                int idc = c+dc[i];
                if(visited[idr][idc]) continue;
                if(map[idr][idc]!=0){
                    queue.add(new int[]{idr,idc});
                    visited[idr][idc] = true;
                }
            }
        }
    }
}