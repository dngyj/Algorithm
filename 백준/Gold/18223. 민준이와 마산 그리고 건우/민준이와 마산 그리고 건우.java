import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int V,E,P;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    static class Node implements Comparable<Node>{
        int v;
        int w;
        Node(int v, int w){
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
        V = sc.nextInt();
        E = sc.nextInt();
        P = sc.nextInt();
        dist = new int[V+1];
        list = new ArrayList[V+1];
        for(int i = 0;i<V+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0;i<E;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }

        int gunwoo =0;
        Arrays.fill(dist,INF);
        dijkstra(1,P);
        gunwoo += dist[P];
        Arrays.fill(dist,INF);
        dijkstra(P,V);
        gunwoo += dist[V];

        Arrays.fill(dist,INF);
        dijkstra(1,V);
        int masan = dist[V];

        if(gunwoo<=masan) System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");

    }
    static void dijkstra(int st, int ed){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[st] = 0;
        queue.add(new Node(st,0));
        while(!queue.isEmpty()){
            Node now = queue.poll();
            int v = now.v;
            int w = now.w;
            if(dist[v]<w) continue;
            for(Node next:list[v]){
                if(dist[next.v]>w+next.w){
                    dist[next.v] = w+next.w;
                    queue.add(new Node(next.v,w+next.w));
                }
            }
        }
    }
}