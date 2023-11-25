import java.util.*;

public class Main {

    static int M,N,K;
    static int[][] map;
    static boolean[][] visited;
    static int depth;
    static int max;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0,0,-1,1};

    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int k = 0 ; k<K; k++) {
            int stX = sc.nextInt();
            int stY = sc.nextInt();
            int edX = sc.nextInt();
            int edY = sc.nextInt();

            for(int r=stY; r<edY; r++) {
                for (int c = stX; c < edX; c++) {
                   map[r][c] = -1;
                }
            }
        }

        for(int r = 0 ; r<M; r++){
            for(int c = 0; c<N; c++){
                if(map[r][c]==0&&!visited[r][c]){
                    depth=0;
                    dfs(r,c);
                    arr.add(depth);
                }
            }
        }
        Collections.sort(arr);
        System.out.println(arr.size());
        for(int a: arr){
            System.out.print(a+" ");
        }
    }


    public static void dfs(int r, int c){
        depth++;
        visited[r][c] = true;

        for(int i = 0 ; i<4; i++){
            int idr = r+dr[i];
            int idc = c+dc[i];

            if(idr<0||idc<0||idr>=M||idc>=N) continue;

            if(map[idr][idc]==0&&!visited[idr][idc]){
                dfs(idr, idc);
            }
        }
    }
}