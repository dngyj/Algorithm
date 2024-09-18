import java.util.*;

public class Main {
    static char[][] map;
    static int[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static ArrayList<int[]> targets;
    static boolean stop = true;
    static int combo = 0;

    public static void main(String[] args) {
        input();
        while(true){
            findBlastTarget();
            dropPuyo();
            if(stop) break;
            combo++;
        }
        System.out.println(combo);
    }

    static void input(){
        Scanner sc = new Scanner(System.in);
        map = new char[12][6];
        for(int r=0;r<12;r++){
            String str = sc.next();
            for(int c=0;c<6;c++){
                map[r][c] = str.charAt(c);
            }
        }
    }
    static void findBlastTarget(){
        stop = true;
        for(int r=0;r<12;r++){
            for(int c=0;c<6;c++){
                if(map[r][c]!='.'){
                    visited = new int[12][6];
                    visited[r][c] = 1;
                    int cnt = bfs(r,c,map[r][c]);
                    if(cnt>=4){
                        stop = false;
                        blastPuyo();
                    }
                }
            }
        }
    }

    static void blastPuyo(){
        for(int[] target:targets){
            int r = target[0];
            int c = target[1];
            map[r][c] = 'T';
        }
    }

    static void dropPuyo(){
        for(int c=0;c<6;c++){
            Stack<Character> stack = new Stack<>();
            for(int r=0;r<12;r++){
                if(map[r][c]!='T'){
                    stack.push(map[r][c]);
                }
            }
            for(int r=11;r>=0;r--){
                if(!stack.isEmpty()) {
                    map[r][c] = stack.pop();
                }
                else map[r][c] = '.';
            }
        }
    }

    static int bfs(int R, int C, char value){
        Queue<int[]> queue = new ArrayDeque<>();
        targets = new ArrayList<>();

        queue.add(new int[]{R,C});
        targets.add(new int[]{R,C});
        int cnt = 1;
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];

            for(int d=0;d<4;d++){
                int idr = r+dr[d];
                int idc = c+dc[d];
                if(idr<0||idc<0||idr>=12||idc>=6) continue;
                if(visited[idr][idc]>=2) continue;
                if(map[idr][idc]==value){
                    if(visited[idr][idc]==0) {
                        queue.add(new int[]{idr,idc});
                        cnt++;
                    }
                    else queue.add(new int[]{idr,idc});
                    visited[idr][idc]++;
                    targets.add(new int[]{idr,idc});
                }
            }
        }
        return cnt;
    }
}