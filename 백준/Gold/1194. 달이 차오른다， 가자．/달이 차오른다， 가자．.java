import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M;
    static char[][] map;
    static boolean[][][] visited;
    static boolean[] key = new boolean[6];
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N][M];
        visited = new boolean[N][M][64];

        for(int r = 0; r<N;r++){
            String str = sc.next();
            for(int c=0; c<M;c++){
                map[r][c] = str.charAt(c);
                if(map[r][c]=='0') {
                    queue.add(new int[]{r,c,0,0});
                    map[r][c] ='.';
                }
            }
        }
        System.out.println(bfs());

    }

    public static int bfs(){

        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            int depth = info[2];
            int key = info[3];

            visited[r][c][key] = true;

            if(map[r][c]=='1') return depth;

            for(int d=0;d<4;d++){
                int idr = r+dr[d];
                int idc = c+dc[d];

                if(idr<0||idc<0||idr>=N||idc>=M) continue;
                if(map[idr][idc]=='#') continue;
                if(visited[idr][idc][key]) continue;

                if(map[idr][idc]>='a'&&map[idr][idc]<='f'){
                    int newKey = key | (1<<(map[idr][idc]-'a'));
                    queue.add(new int[]{idr,idc,depth+1, newKey});
                    visited[idr][idc][newKey] = true;
                }

                if(map[idr][idc]>='A'&&map[idr][idc]<='F') {
                    if((key & (1<<(map[idr][idc]-'A')))!=0){
                        queue.add(new int[]{idr,idc,depth+1, key});
                        visited[idr][idc][key] = true;
                    }
                }
                else{
                    visited[idr][idc][key] = true;
                    queue.add(new int[]{idr,idc,depth+1,key});
                }
            }
        }
        return -1;
    }
}