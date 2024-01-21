import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int N,E;
    static int INF = 1000*200000;
    static int[] dist;
    static class Node implements Comparable<Node>{
        int v;
        int w;
        public Node(int v, int w){
            this.v=v;
            this.w=w;
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
        E = sc.nextInt();

        dist = new int[N+1];
        list = new ArrayList[N+1];
        for(int i = 0; i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0;i<E;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int w = sc.nextInt();
            list[st].add(new Node(ed,w));
            list[ed].add(new Node(st,w));
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        int ans1 = 0;
        Arrays.fill(dist, INF);
        dijkstra(v1);
        ans1 = dist[1]+dist[v2];
        Arrays.fill(dist, INF);
        dijkstra(v2);
        ans1 += dist[N];

        int ans2 = 0;
        Arrays.fill(dist, INF);
        dijkstra(v2);
        ans2 = dist[1]+dist[v1];
        Arrays.fill(dist, INF);
        dijkstra(v1);
        ans2 += dist[N];

        int ans = Math.min(ans1,ans2);
        if(ans>=INF) System.out.println(-1);
        else System.out.println(ans);

    }
    static void dijkstra(int st){
        dist[st] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(st, 0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int v = node.v;
            int w = node.w;
            if(dist[v]<w) continue;
            for(Node next : list[v]){
                if(dist[next.v]>w+next.w){
                    dist[next.v]=w+next.w;
                    queue.add(new Node(next.v, w+next.w));
                }
            }
        }
    }
}