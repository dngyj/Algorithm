import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int len;
    static int min, result;
    static int[][] board;
    static int target_r, target_c;

    static int[] dr = {2,2,1,1,-1,-1,-2,-2};
    static int[] dc = {1,-1,2,-2,2,-2,1,-1};

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){

            len = sc.nextInt();


            int now_r = sc.nextInt();
            int now_c = sc.nextInt();

            target_r = sc.nextInt();
            target_c = sc.nextInt();

            board = new int[len][len];
            board[now_r][now_c] =1;

            queue.add(new int[]{now_r, now_c});

            int INF = Integer.MAX_VALUE;
            min = INF;

            bfs();

            if(min==INF) System.out.println(0);
            else System.out.println(min-1);


        }
    }

    private static void bfs() {

        while(!queue.isEmpty()){
            int[] dot = queue.poll();
            int r = dot[0];
            int c = dot[1];

            for(int d=0;d<8;d++) {
                int idr = r + dr[d];
                int idc = c + dc[d];

                if (idr < 0 || idc < 0 || idr >= len || idc >= len) continue;

                if(board[idr][idc]==0){
                    board[idr][idc] = board[r][c] + 1;
                    queue.add(new int[]{idr, idc});
                }

                else if (idr == target_r && idc == target_c) {
                    result = board[target_r][target_c];
                    min = Math.min(min, result);
                }
            }
        }
    }
}