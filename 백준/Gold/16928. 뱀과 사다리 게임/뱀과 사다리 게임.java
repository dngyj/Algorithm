import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] map = new int[101];
    static boolean[] visited = new boolean[102];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i = 0;i<101;i++){
            map[i] = i;
        }
        for(int i = 0;i<N;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x] = y;
        }
        for(int i =0; i<M;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            map[u] =v;
        }
        bfs();
    }

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});

        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int idx = info[0];
            int cnt = info[1];
            if(idx>=101) continue;
            visited[idx] = true;
            int loc = map[idx];

            if(loc == 100){
                System.out.println(cnt);
                return;
            }
            else {
                for (int dice = 1; dice <= 6; dice++) {
                    if(loc+dice<=101 && !visited[loc+dice]) {
                        queue.add(new int[]{loc + dice, cnt + 1});
                    }
                }
            }
        }
    }
}