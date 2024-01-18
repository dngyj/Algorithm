import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int INF = Integer.MAX_VALUE;
    static long[] dist;
    static class Node{
        int v;
        int w;
        public Node(int v, int w){
            this.v=v;
            this.w=w;
        }
    }
    static ArrayList<Node>[] list;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        dist = new long[N+1];
        Arrays.fill(dist, INF);
        list = new ArrayList[N+1];
        for(int i =0;i<N+1;i++) list[i] = new ArrayList<>();

        for(int i = 0; i<M; i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int time = sc.nextInt();
            list[st].add(new Node(ed,time));
        }
        if(bellmanFord()){
            sb.append("-1\n");
        }else{
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(dist[i] + "\n");
                }
            }
        }
        System.out.println(sb);

    }
    static boolean bellmanFord(){
        dist[1] = 0;
        for(int i=1;i<N+1;i++){

            for(int j=1;j<N+1;j++){
                for(Node node : list[j]) {
                    if (dist[j] == INF) continue;
                    if (dist[node.v]>dist[j]+node.w){
                        dist[node.v] = dist[j]+node.w;
                        if(i==N) return true;
                    }
                }
            }
        }
        return false;
    }
}