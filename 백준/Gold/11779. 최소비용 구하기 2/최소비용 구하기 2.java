import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int INF = Integer.MAX_VALUE;
    static int[] dp;
    static int[] idx;
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
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        idx = new int[N+1];
        dp = new int[N+1];
        Arrays.fill(dp, INF);
        list = new ArrayList[N+1];
        for(int i = 0; i<=N;i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i<M;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int w = sc.nextInt();
            list[st].add(new Node(ed,w));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        dijkstra(start);

        System.out.println(dp[end]);
        int target = end;
        int cnt =0;
        while(target!=0){
            sb.insert(0,target+" ");
            target = idx[target];
            cnt++;
        }
        System.out.println(cnt);
        System.out.println(sb);
    }

    public static void dijkstra(int st){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(st, 0));
        dp[st] = 0;
        idx[st] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int v = node.v;
            int w = node.w;
            
            if(dp[v]<w) continue;
            
            for(int i = 0; i<list[v].size();i++){
                int v2 = list[v].get(i).v;
                int w2 = list[v].get(i).w+w;
                if(dp[v2]>w2){
                    dp[v2] = w2;
                    idx[v2] = v;
                    queue.add(new Node(v2,w2));
                }
            }
        }
    }
}