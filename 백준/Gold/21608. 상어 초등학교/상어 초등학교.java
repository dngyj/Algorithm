import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static ArrayList<Integer>[] list;
    static class Node{
        int like;
        int blank;

        Node(int like, int blank){
            this.like=like;
            this.blank=blank;
        }
    }
    static Node[][] info;
    static int sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        list = new ArrayList[N*N];
        for(int i = 0;i<N*N;i++) list[i] = new ArrayList<>();

        for(int i = 0;i<N*N;i++){
            for(int j=0;j<5;j++){
                int num = sc.nextInt();
                list[i].add(num);
            }
        }

        setMap();
        calSatisfy();
        System.out.println(sum);

    }
    static void setMap(){
        map[1][1] = list[0].get(0);

        for(int i = 1;i<N*N;i++){
            int likeMax = -1;
            info = new Node[N][N];

            for(int r = 0;r<N;r++){
                for(int c= 0;c<N;c++){
                    if(map[r][c]==0){
                        int like = 0; //좋아하는 수 체크
                        int blank=0;
                        for(int d=0;d<4;d++){ //4방 탐색
                            int idr = r+dr[d];
                            int idc = c+dc[d];
                            if(idr<0||idc<0||idr>=N||idc>=N) continue;
                            for(int k = 1;k<5;k++) {
                                if (map[idr][idc] == list[i].get(k)){
                                    like++;
                                }
                            }
                            //빈 칸 체크
                            if(map[r+dr[d]][c+dc[d]]==0) blank++;
                        }
                        info[r][c] = new Node(like,blank);
                        likeMax = Math.max(like,likeMax);
                    }
                }
            }
            int num = list[i].get(0);
            int R = -1;
            int C = -1;
            int blankMax = -1;
            for(int r = 0;r<N;r++){
                for(int c= 0;c<N;c++){
                    if(map[r][c]==0&&info[r][c].like==likeMax){
                        int blank = info[r][c].blank;
                        if(blank>blankMax){
                            blankMax = blank;
                            R = r;
                            C = c;

                        }
                    }
                }
            }
            map[R][C] = num;
        }
    }

    static void calSatisfy(){
        for(int r = 0;r<N;r++){
            for(int c= 0;c<N;c++){
                int cnt = 0;
                int num = -1;
                for(int i = 0;i<N*N;i++) {
                    if(map[r][c]==list[i].get(0)){
                        num = i;
                        break;
                    }
                }

                for(int d=0;d<4;d++){ //4방 탐색
                    int idr = r+dr[d];
                    int idc = c+dc[d];
                    if(idr<0||idc<0||idr>=N||idc>=N) continue;

                    for(int k = 1;k<5;k++) {
                        if (map[idr][idc] == list[num].get(k)){
                            cnt++;
                        }
                    }
                }
                if(cnt==1) sum+=1;
                if(cnt==2) sum+=10;
                if(cnt==3) sum+=100;
                if(cnt==4) sum+=1000;
            }
        }
    }
}