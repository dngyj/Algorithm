import java.util.*;

public class Main {

    static int N, M, cnt;
    static int[] dp;
    static int INF = Integer.MAX_VALUE;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        dp = new int[N+1];

        list = new ArrayList[N+1];
        for(int i = 1; i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i<M; i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            list[st].add(ed);
            list[ed].add(st);
        }
        int idx=-1;
        for(int i = 1; i<N+1;i++) {
            cnt = 0;
            bfs(i);
            if(cnt<min){
                min = cnt;
                idx = i;
            }
        }
        System.out.println(idx);
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Arrays.fill(dp,INF);
        dp[start] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i);
                if(dp[next]>dp[now]+1) {
                    dp[next] = dp[now]+1;
                    cnt+=dp[next];
                    queue.add(next);
                }
            }
        }
    }
}