import java.util.Scanner;

public class Main {
    static int R,C,K;
    static int answer = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        map = new char[R][C];
        visited = new boolean[R][C];

        for(int r=0; r<R;r++){
            String str = sc.next();
            for(int c=0; c<C;c++){
                map[r][c] = str.charAt(c);
            }
        }
        visited[R-1][0] = true;
        dfs(R-1,0,1);
        System.out.println(answer);
    }
    static void dfs(int r, int c, int cnt){
        if(r==0&&c==C-1){
            if(cnt==K) answer++;
        }
        else{
            for(int d= 0; d<4;d++){
                int idr = r+dr[d];
                int idc = c+dc[d];
                if(idr<0||idc<0||idr>=R||idc>=C) continue;
                if(!visited[idr][idc]&&map[idr][idc]!='T'){
                    visited[idr][idc] = true;
                    dfs(idr,idc,cnt+1);
                    visited[idr][idc] = false;
                }
            }
        }
    }
}