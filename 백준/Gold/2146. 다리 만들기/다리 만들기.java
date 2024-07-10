import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int INF = Integer.MAX_VALUE;
    static int partNum = 1;
    static List<int[]> lands = new ArrayList<>();

    public static void main(String[] args) {
        input();
        visited = new boolean[N][N];
        for(int[] pos : lands){
            int r = pos[0];
            int c = pos[1];
            if(!visited[r][c]) {
                checkPart(r,c);
                partNum++;
            }
        }

        int min = INF;
        for(int[] pos : lands){
            int r = pos[0];
            int c = pos[1];
            visited = new boolean[N][N];
            min = Math.min(bfs(r,c,map[r][c]), min);
        }
        System.out.println(min);
    }

    static int bfs(int row, int col, int landNum){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row,col,0});
        visited[row][col] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = cur[2];
            if(map[r][c]!=0&&map[r][c]!=landNum) return cnt-1;

            for(int d = 0 ; d<4;d++){
                int idr = r+dr[d];
                int idc = c+dc[d];
                if(idr<0||idc<0||idr>=N||idc>=N) continue;
                if(map[idr][idc]==landNum) continue;

                if(!visited[idr][idc]){
                    visited[idr][idc] = true;
                    queue.add(new int[]{idr,idc,cnt+1});
                }
            }
        }
        return INF;
    }

    static void checkPart(int row, int col){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row,col});
        visited[row][col] = true;
        map[row][col] = partNum;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for(int d = 0 ; d<4;d++){
                int idr = r+dr[d];
                int idc = c+dc[d];
                if(idr<0||idc<0||idr>=N||idc>=N) continue;
                if(map[idr][idc]==0) continue;

                if(!visited[idr][idc]){
                    visited[idr][idc] = true;
                    map[idr][idc] = partNum;
                    queue.add(new int[]{idr,idc});
                }
            }
        }
    }

    static void input(){
        N = sc.nextInt();
        map = new int[N][N];
        for(int r = 0; r<N;r++){
            for(int c=0; c<N;c++){
                int num = sc.nextInt();
                if(num==1) {
                    map[r][c] = 1;
                    lands.add(new int[]{r,c});
                }
                else map[r][c] = 0;
            }
        }
    }

}