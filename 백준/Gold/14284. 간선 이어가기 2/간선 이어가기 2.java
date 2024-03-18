import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int s,t;
    static int INF = 987654321;
    static int[] dist;
    static ArrayList<Node>[] list;
    static class Node implements Comparable<Node>{
        int v;
        int w;
        Node(int v, int w){
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
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        list = new ArrayList[N+1];
        for(int i = 0; i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            list[a].add(new Node(b, w));
            list[b].add(new Node(a,w));
        }
        s = sc.nextInt();
        t = sc.nextInt();
        dikstra(s);
        System.out.println(dist[t]);
    }

    static void dikstra(int st){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(st, 0));
        dist[st] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int v = node.v;
            int w = node.w;
            if(dist[v]<w) continue;
            for(int i = 0; i<list[v].size();i++){
                Node next = list[v].get(i);
                int v2 = next.v;
                int w2 = w+next.w;
                if(dist[v2]>w2){
                    dist[v2] = w2;
                    queue.add(new Node(v2, w2));
                }
            }
        }
    }
}