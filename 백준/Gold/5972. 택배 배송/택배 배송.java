import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int INF = Integer.MAX_VALUE;
    static int[] dp;
    static ArrayList<Node>[] list;


    public static class Node implements Comparable<Node>{
        int v;
        int w;

        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Node o){
            return w-o.w;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        dp = new int[N+1];
        Arrays.fill(dp, INF);

        list = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<M;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int cost = sc.nextInt();
            list[st].add(new Node(ed, cost));
            list[ed].add(new Node(st, cost));
        }

        dijkstra();
        System.out.println(dp[N]);
    }

    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        dp[0] = 0;
        dp[1] = 0;

        while(!pq.isEmpty()){

            Node node = pq.poll();
            int v = node.v;
            int cost = node.w;

            if(dp[v]<cost) continue;

            for(int i = 0; i<list[v].size();i++){
                int v2 = list[v].get(i).v;
                int w2 = list[v].get(i).w+cost;
                if(dp[v2]>w2){
                    dp[v2] = w2;
                    pq.add(new Node(v2, w2));
                }
            }
        }
    }
}