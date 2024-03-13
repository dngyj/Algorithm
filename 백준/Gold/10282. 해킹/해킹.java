import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int N,D,C;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
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
        int T = sc.nextInt();
        for(int tc=0;tc<T;tc++){
            N = sc.nextInt();
            D = sc.nextInt();
            C = sc.nextInt();
            list = new ArrayList[N+1];
            for(int i = 0; i<N+1;i++){
                list[i] = new ArrayList<>();
            }
            dist = new int[N+1];
            Arrays.fill(dist, INF);

            for(int i = 0; i<D;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int s = sc.nextInt();
                list[b].add(new Node(a,s));
            }
            dikstra(C);
            int cnt = 0;
            int max = -1;
            for(int i = 1; i<N+1;i++){
                if(dist[i]!=INF){
                    cnt++;
                    max = Math.max(max, dist[i]);
                }
            }
            System.out.print(cnt+" ");
            System.out.println(max);
        }
    }

    static void dikstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[start] = 0;
        queue.add(new Node(start, 0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int v = node.v;
            int w = node.w;

            if(dist[v]<w) continue;
            for(int i = 0; i<list[v].size();i++){
                int v2 = list[v].get(i).v;
                int w2 = list[v].get(i).w+w;
                if(dist[v2]>w2){
                    dist[v2] = w2;
                    queue.add(new Node(v2,w2));
                }
            }
        }
    }
}