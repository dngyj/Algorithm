import java.util.*;

public class Main {

    static int N,M,target,start;
    static final int INF = Integer.MAX_VALUE;
    static int[] dp;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        target = sc.nextInt();
        start = sc.nextInt();

        dp = new int[N+1];
        Arrays.fill(dp, INF);

        list = new ArrayList[N+1];
        for(int i =1; i<=N;i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            list[st].add(ed);
        }

        dijkstra(start);

        boolean flag = false;
        for(int i = 1; i<N+1; i++){
            if(dp[i]==target){
                flag = true;
                System.out.println(i);
            }
        }
        if(!flag) System.out.println(-1);


    }
    public static void dijkstra(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        dp[start] = 0;

        while(!queue.isEmpty()){

            int v = queue.poll();

            for(int i = 0 ; i<list[v].size(); i++) {
                int v2 = list[v].get(i);
                if(dp[v2]>dp[v] + 1) {
                    dp[v2] = dp[v] + 1;
                    queue.add(v2);
                }
            }
        }
    }

}