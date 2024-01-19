import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int N,M,X;
    static int INF = Integer.MAX_VALUE;
    static int[] dist;
    static int[] ans;
    static class Node implements Comparable<Node>{
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
    static ArrayList<Node>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();
        list = new ArrayList[N+1];
        for(int i =0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0;i<M;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int cost = sc.nextInt();
            list[st].add(new Node(ed, cost));
        }

        ans = new int[N+1];
        for(int i=1;i<N+1;i++){
            dist = new int[N+1];
            Arrays.fill(dist, INF);
            dijkstra(i);
            if(i==X){
                for(int k = 1; k<N+1;k++) {
                    ans[k] += dist[k];
                }
            }
            else ans[i] += dist[X];
        }

        int max = -1;
        for(int i = 1; i<N+1;i++) {
            max = Math.max(max,ans[i]);
        }
        System.out.println(max);

    }

    static void dijkstra(int st){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[st] = 0;
        queue.add(new Node(st,0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int v = node.v;
            int w = node.w;
            if(dist[v]<w) continue;
            for(Node next : list[v]){
                if(dist[next.v]>w+next.w) {
                    dist[next.v] = w+next.w;
                    queue.add(new Node(next.v, w+next.w));
                }
            }
        }
    }
}