import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int[][] map = new int[5][5];
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int r = 0;r<5;r++){
            for(int c=0;c<5;c++){
                map[r][c] = sc.nextInt();
            }
        }
        for(int r = 0;r<5;r++){
            for(int c=0;c<5;c++){
                dfs(r,c,1,map[r][c]+"");
            }
        }
        System.out.println(set.size());
    }
    static void dfs(int r, int c, int cnt, String s){
        if(cnt==6){
            set.add(s);
        }
        else {
            for(int i = 0; i<4;i++){
                int idr = r+dr[i];
                int idc = c+dc[i];
                if(idr<0||idc<0||idr>=5||idc>=5) continue;
                dfs(idr,idc,cnt+1,s+map[idr][idc]);
            }
        }
    }
}