import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int[][] map;
    static int[][] clouds;
    static class Movement{
        int d;
        int s;
        Movement(int d, int s){
            this.d=d;
            this.s=s;
        }
    }

    static int[] dr = {0,-1,-1,-1,0,1,1,1};
    static int[] dc = {-1,-1,0,1,1,1,0,-1};

    static ArrayList<Movement> list = new ArrayList<>();
    static ArrayList<int[]> waters;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        clouds = new int[N][N];
        for(int r =0;r<N;r++){
            for(int c=0;c<N;c++){
                map[r][c] = sc.nextInt();
            }
        }
        for(int i = 0;i<M;i++){
            int d = sc.nextInt()-1;
            int s = sc.nextInt();
            list.add(new Movement(d,s));
        }
        magic();
    }

    static void magic(){
        for(int r = N-2;r<N;r++){
            for(int c=0;c<2;c++){
                clouds[r][c] = 1;
            }
        }
        for(int i = 0; i<M;i++) {
            int d = list.get(i).d;
            int s = list.get(i).s;
            moveClouds(d,s);
            waters = new ArrayList<>();
            rain();
            copyWater();
            makeCloud();
        }
        System.out.println(getSum());

    }

    static void moveClouds(int d, int s){
        ArrayList<int[]> nows = new ArrayList<>();
        for(int r =0;r<N;r++){
            for(int c=0;c<N;c++){
                if(clouds[r][c]==1){
                    nows.add(new int[]{r,c});
                    clouds[r][c] = 0;
                }
            }
        }

        for(int i=0;i<nows.size();i++){
            int nowR = nows.get(i)[0];
            int nowC = nows.get(i)[1];
            
            int nextR = 0;
            int nextC = 0;
            if(nowR+dr[d]*s>=0) nextR = (nowR+dr[d]*s)%N;
            else{
                if(Math.abs(nowR+dr[d]*s)%N==0) nextR = 0;
                else nextR = N-Math.abs(nowR+dr[d]*s)%N;
            }

            if(nowC+dc[d]*s>=0) nextC = (nowC+dc[d]*s)%N;
            else{
                if(Math.abs(nowC+dc[d]*s)%N==0) nextC = 0;
                else nextC = N-Math.abs(nowC+dc[d]*s)%N;
            }
            clouds[nextR][nextC] = 1;
        }
    }

    static void rain(){
        for(int r =0;r<N;r++){
            for(int c=0;c<N;c++){
                if(clouds[r][c]==1){
                   map[r][c]++;
                   clouds[r][c] = 0;
                   waters.add(new int[]{r,c});
                }
            }
        }
    }

    static void copyWater(){
        ArrayList<int[]> copyWaters = new ArrayList<>();
        for(int i=0;i<waters.size();i++){
            int r = waters.get(i)[0];
            int c = waters.get(i)[1];
            int cnt = 0;
            for(int d=1;d<8;d+=2){
                int idr = r+dr[d];
                int idc = c+dc[d];
                if(idr<0||idc<0||idr>=N||idc>=N) continue;
                if(map[idr][idc]>0) cnt++;

            }
            copyWaters.add(new int[]{r,c,cnt});
        }
        for(int i=0;i<copyWaters.size();i++){
            int r = copyWaters.get(i)[0];
            int c = copyWaters.get(i)[1];
            int cnt =copyWaters.get(i)[2];
            map[r][c] += cnt;
        }
    }
    static void makeCloud(){
        for(int r =0;r<N;r++){
            outer: for(int c=0;c<N;c++){
                if(map[r][c]>=2){
                    for(int i = 0;i<waters.size();i++){
                        if(r==waters.get(i)[0]&&c==waters.get(i)[1]) continue outer;
                    }
                    clouds[r][c] = 1;
                    map[r][c]-=2;
                }
            }
        }
    }
    static int getSum(){
        int sum = 0;
        for(int r =0;r<N;r++){
            for(int c=0;c<N;c++){
                sum+=map[r][c];
            }
        }
        return sum;
    }
}