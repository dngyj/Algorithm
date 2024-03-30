import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N,M;
    static long[] dist;
    static Long INF = Long.MAX_VALUE;
    static class Node implements Comparable<Node>{
        int v;
        long w;
        Node(int v, long w){
            this.v=v;
            this.w=w;
        }
        @Override
        public int compareTo(Node o){
            return Long.compare(w,o.w);
        }
    }
    static ArrayList<Node>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        dist = new long[N+1];
        Arrays.fill(dist,INF);
        list = new ArrayList[N+1];
        for(int i =0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            list[st].add(new Node(ed,i));
            list[ed].add(new Node(st,i));
        }
        dijkstra(1);
        System.out.println(dist[N]);
    }
    static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[start] = 0;
        queue.add(new Node(start,0));

        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(dist[current.v]<current.w) continue;

            for(Node next:list[current.v]){

                if(next.w>=current.w) next.w = next.w+1;
                else next.w = ((long)Math.ceil(((double)current.w-next.w)/M))*M+next.w+1;

                if(dist[next.v]>next.w){
                    dist[next.v] = next.w;
                    queue.add(new Node(next.v,next.w));
                }
            }
        }
    }
}