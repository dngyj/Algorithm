import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[][] map;
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
        day();
    }

    static void day(){
        int time = 0;
        while(true){
            fillAir(0,0);
            boolean isNothing = true;
            for(int r=0;r<N;r++){
                for(int c=0;c<M;c++){
                    if(map[r][c]==1) {
                        isMelting(r, c);
                        isNothing = false;
                    }
                }
            }
            if(isNothing) break;
            for(int r=0;r<N;r++){
                for(int c=0;c<M;c++){
                    if(map[r][c]==-1) {
                        map[r][c]=0;
                    }
                }
            }
            time++;
        }
        System.out.println(time);
    }
    static void isMelting(int r, int c){
        int cnt = 0;
        for(int i =0; i<4;i++){
            int idr = r+dr[i];
            int idc = c+dc[i];
            if(idr<0||idc<0||idr>=N||idc>=M) continue;
            if(map[idr][idc]==-1){
               cnt++;
            }
        }
        if(cnt>=2) {
            map[r][c] = 0;
        }
    }

    static void fillAir(int row, int col){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        map[row][col] = -1;
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int r= info[0];
            int c= info[1];
            for(int i =0; i<4;i++){
                int idr = r+dr[i];
                int idc = c+dc[i];
                if(idr<0||idc<0||idr>=N||idc>=M) continue;
                if(map[idr][idc]==0){
                    map[idr][idc]= -1;
                    queue.add(new int[]{idr,idc});
                }
            }
        }
    }
}