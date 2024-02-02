import java.util.Scanner;

public class Main {

    static int R, C;
    static char[][] map;
    static boolean[] alpha;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int ans = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        alpha = new boolean[26];

        for(int i = 0;i<R;i++){
            map[i] = sc.next().toCharArray();
        }
        dfs(0,0,0);
        System.out.println(ans);
    }
    static void dfs(int r, int c,int cnt){
        if(alpha[map[r][c]-'A']){
            ans = Math.max(cnt, ans);
            return;
        }
        else {
            alpha[map[r][c] - 'A'] = true;
            for (int i = 0; i < 4; i++) {
                int idr = r + dr[i];
                int idc = c + dc[i];
                if (idr < 0 || idc < 0 || idr >= R || idc >= C) continue;
                dfs(idr, idc, cnt + 1);
            }
            alpha[map[r][c] - 'A'] = false;
        }
    }
}