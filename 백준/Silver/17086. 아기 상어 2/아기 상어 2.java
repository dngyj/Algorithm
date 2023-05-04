import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] area;
    static int N,M,max;
    static int[] dr = {0, 0, -1, 1,-1,-1,1,1};
    static int[] dc = {1, -1, 0, 0,1,-1,1,-1};

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M= sc.nextInt();

        area = new int[N][M];

        for(int r=0;r<N;r++){
            for(int c=0; c<M;c++) {
                area[r][c] = sc.nextInt();
            }
        }

        for(int r=0; r<N;r++){
            for(int c=0; c<M;c++){
                if(area[r][c]==1)
                    queue.add(new int[]{r,c});
            }
        }
        bfs();
        System.out.println(max-1);
    }

    private static void bfs() {

        while(!queue.isEmpty()){
            int[] dot = queue.poll();
            int r = dot[0];
            int c = dot[1];


            for(int i=0; i<8;i++){
                int idr = r+dr[i];
                int idc = c+dc[i];

                if(idr<0||idc<0||idr>=N||idc>=M) continue;

                if(area[idr][idc]==0){
                    area[idr][idc] = area[r][c]+1;
                    queue.add(new int[]{idr, idc});
                }
            }
        }
        max = Integer.MIN_VALUE;

        for(int r=0;r<N;r++){
            for(int c=0; c<M; c++){
                max = Math.max(max, area[r][c]);
            }
        }
    }
}