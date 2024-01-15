import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] list;
    static int N;
    static int[][] ans;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ans = new int[N][N];
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (sc.nextInt() == 1) {
                    list[r].add(c);
                    ans[r][c] =1;
                    queue.add(new int[]{r, c});
                }
            }
        }
        bfs();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(ans[r][c]+" ");
            }
            System.out.println();
        }
    }

    static void bfs() {
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int st = info[0];
            int ed = info[1];

            for (int i = 0; i < list[ed].size(); i++) {
                int nextEd = list[ed].get(i);
                if (ans[st][nextEd]==1) continue;
                ans[st][nextEd] = 1;
                queue.add(new int[]{st,nextEd});
            }
        }
    }
}