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
        long time;
        Node(int v, long time){
            this.v=v;
            this.time=time;
        }
        @Override
        public int compareTo(Node o){
            return (int)(time-o.time);
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
        for(int i=1;i<=M;i++){
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
            if(dist[current.v]<current.time) continue;

            for(Node next:list[current.v]){
                long order = current.time%M; //현재 시간이 주기내에서 몇번째 위치인지
                order = next.time-order; // 다음에 올 순서와 지금의 순서를 뺴준다.
                if(order<0) order+=M; //다음시간이 temp보다 작으면, 즉 순서가 낮으면 주기 더해주기 음수 값이 나온다는 것은 이미 다음 이동 순서가 현재 주기에서 지나갔다는 것
                long nextTime = order+current.time; // 최종적으로 다음 노드에 도달하기까지의 총 시간을 계산
                //이는 다음 노드로 이동할 때까지 기다려야 하는 총 시간

                if(dist[next.v]>nextTime){
                    dist[next.v] = nextTime;
                    queue.add(new Node(next.v,nextTime));
                }
            }
        }
    }
}