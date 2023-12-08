import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int V, E, start;
    static ArrayList<Node>[] list;
    static int[] dp;

    public static class Node implements Comparable<Node> {

        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        V = sc.nextInt(); // 정점의 개수
        E = sc.nextInt(); // 간선의 개수

        list = new ArrayList[V + 1]; // 정점의 인접 리스트
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        dp = new int[V + 1]; // key라고 불린 가장 작은 값 저장하는 용도
        Arrays.fill(dp, INF);
        dp[start] = 0;

        for (int i = 0; i < E; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int w = sc.nextInt();
            list[st].add(new Node(ed, w));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        System.out.println(dijkstra(start, end));

    }


    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        dp[start] = 0;
//        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {

            Node node = queue.poll();
            int v = node.v;
            int w = node.w;
            if (dp[v] < w) { //지금께 더 가중치가 크면 갱신할 필요가 없다.
                continue;
            }
            for (int i = 0; i < list[v].size(); i++) {//해당 정점과 연결된 것들 탐색
                int v2 = list[v].get(i).v;
                int w2 = list[v].get(i).w + w;
                if (dp[v2] > w2) { //지금것이 더 최단경로라면 갱신해준다.
                    dp[v2] = w2;
                    queue.add(new Node(v2, w2));
                }
            }
        }
        return dp[end]; // 해당목적지의 dist값을 출력해준다.
    }
}