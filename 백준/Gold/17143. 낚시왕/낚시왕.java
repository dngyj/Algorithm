import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int R,C,M;
    static int fishmanCol;
    static int sum;
    static int[] dr = {-1,0,1,0};
    static int[] dc= {0,-1,0,1};
    static class Shark{
        int s;
        int d;
        int z;
        Shark(int s, int d, int z){
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    static Shark[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        M = sc.nextInt();
        map = new Shark[R][C];

        for(int i=0;i<M;i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            int z = sc.nextInt();
            if(d==1) d=0;
            else if(d==4) d=1;

            map[r-1][c-1] = new Shark(s,d,z);
        }
        fishmanCol = 0;
        sum = 0;
        simul();
        System.out.println(sum);
    }

    static void simul(){
        while(fishmanCol<C) {
            fishing(fishmanCol++);
            moveShark();
        }
    }

    static void fishing(int col){
        for(int r = 0;r<R;r++){
            if(map[r][col]!=null){
                sum+=map[r][col].z;
                map[r][col] = null;
                break;
            }
        }
    }
    static void moveShark(){
        Queue<int[]> queue = new LinkedList<>();
        for(int r = 0; r<R;r++){
            for(int c = 0; c<C;c++){
                if(map[r][c]!=null){
                    queue.add(new int[]{r,c,map[r][c].s,map[r][c].d,map[r][c].z});
                }
            }
        }

        map = new Shark[R][C];

        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            int speed = info[2];
            int d = info[3];
            int size = info[4];

            if(d==0||d==2) speed %=(R-1)*2;
            else speed%=(C-1)*2;

            for(int i = 0;i<speed;i++){
                int idr = r+dr[d];
                int idc = c+dc[d];

                if(idr<0||idc<0||idr>=R||idc>=C){
                    r-=dr[d];
                    c-=dc[d];
                    d = (d+2)%4;
                    continue;
                }
                r = idr;
                c = idc;
            }
            if(map[r][c]!=null){
                if(size>map[r][c].z){
                        map[r][c] = new Shark(speed, d, size);
                }
            }
            else map[r][c] = new Shark(speed,d,size);
        }
    }
}