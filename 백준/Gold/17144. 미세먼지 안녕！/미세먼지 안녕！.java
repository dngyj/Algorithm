import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[][] map;
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};
    static ArrayList<int[]> list;
    static int[] loc = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int T = sc.nextInt();
        map = new int[N][M];
        for(int r=0;r<N;r++){
            for(int c=0;c<M;c++){
                map[r][c] = sc.nextInt();
                if(map[r][c]==-1){
                    loc[1] = r;
                    loc[0] = r-1;
                }
            }
        }
        int t=0;
        while(t<T) {
            list = new ArrayList<>();
            //1.확산
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] > 0) {
                        list.add(new int[]{r,c,map[r][c]/5});
                    }
                }
            }
            diffusion();
            //2.공기청정기 작동
            airCleaner();

            t++;
        }
        System.out.println(munjiSum());
    }
    
    public static void diffusion(){
        for(int i = 0;i<list.size();i++){
            int r = list.get(i)[0];
            int c = list.get(i)[1];
            int amount = list.get(i)[2];
            int cnt = 0;
            for(int d=0;d<4;d++){
                int idr = r+dr[d];
                int idc = c+dc[d];
                if(idr<0||idc<0||idr>=N||idc>=M) continue;
                if(map[idr][idc]==-1) continue;
                map[idr][idc] += amount;
                cnt++;
            }
            map[r][c] = map[r][c] - amount*cnt;
        }
    }

    public static void airCleaner(){
        int upR = loc[0];
        int downR = loc[1];

        //1. 위
        //왼쪽 아래로 내리기
        for(int r=upR-1;r>0;r--){
            map[r][0] = map[r-1][0];
        }
        //위쪽 왼쪽으로 밀기
        for(int c=0;c<M-1;c++){
            map[0][c] = map[0][c+1];
        }
        //오른쪽 위로 올리기
        for(int r=0;r<=upR-1;r++){
            map[r][M-1] = map[r+1][M-1];
        }
        //아래쪽 오른쪽으로 밀기
        for(int c=M-1;c>1;c--){
            map[upR][c] = map[upR][c-1];
        }
        map[upR][1] = 0;

        //2. 아래
        //왼쪽 위로 올리기
        for(int r=downR+1;r<N-1;r++){
            map[r][0] = map[r+1][0];
        }
        //아래쪽 왼쪽으로 밀기
        for(int c=0;c<M-1;c++){
            map[N-1][c] = map[N-1][c+1];
        }
        //오른쪽 아래로 내리기
        for(int r=N-1;r>downR;r--){
            map[r][M-1] = map[r-1][M-1];
        }
        //위쪽 오른쪽으로 밀기
        for(int c=M-1;c>1;c--){
            map[downR][c] = map[downR][c-1];
        }
        map[downR][1] = 0;
    }
    static int munjiSum(){
        int sum =0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] >= 0) {
                    sum+=map[r][c];
                }
            }
        }
        return sum;
    }

}