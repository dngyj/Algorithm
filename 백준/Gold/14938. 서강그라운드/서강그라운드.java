import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int N,M,R;
    static int[] items;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    static int item;
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
        R = sc.nextInt();
        items = new int[N+1];
        for(int i =1;i<N+1;i++){
            items[i] = sc.nextInt();
        }
        list = new ArrayList[N+1];
        for(int i =0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0;i<R;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int cost = sc.nextInt();
            list[st].add(new Node(ed,cost));
            list[ed].add(new Node(st,cost));
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i<N+1;i++) {
            item = 0;
            dist = new int[N+1];
            Arrays.fill(dist,INF);
            dijkstra(i);
            ans = Math.max(ans,item);
        }
        System.out.println(ans);
    }
    static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[start] = 0;
        queue.add(new Node(start,0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int v = node.v;
            int w = node.w;
            if(dist[v]<w) continue;
            for(int i =0;i<list[v].size();i++){
                int v2 = list[v].get(i).v;
                int w2 = list[v].get(i).w+w;
                if(dist[v2]>w2){
                    dist[v2] = w2;
                    queue.add(new Node(v2, w2));
                }
            }
        }
        for(int i = 1; i<N+1;i++) {
            if(dist[i]<=M) {
                item+=items[i];
            }
        }
    }
}