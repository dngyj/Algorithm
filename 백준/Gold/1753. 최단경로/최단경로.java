import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int V, E, start;
    static ArrayList<Node>[] list;
    static int[] dist;

    public static class Node implements Comparable<Node> {

        int ed;
        int w;

        public Node(int ed, int w) {
            this.ed = ed;
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
        start = sc.nextInt(); // 시작 정점의 번호

        list = new ArrayList[V + 1]; // 정점의 인접 리스트
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        dist = new int[V + 1]; // key라고 불린 가장 작은 값 저장하는 용도
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 0; i < E; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int w = sc.nextInt();
            list[st].add(new Node(ed, w));
        }

        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }


    private static void dijkstra() {
            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(start, 0));
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int v = node.ed;
                int weight = node.w;
                if (dist[v] < weight) { //지금께 더 가중치가 크면 갱신할 필요가 없다.
                    continue;
                }
                for (int i = 0; i < list[v].size(); i++) {//해당 정점과 연결된 것들 탐색
                    int vertex2 = list[v].get(i).ed;
                    int weight2 = list[v].get(i).w + weight;
                    if (dist[vertex2] > weight2) { //지금께 더 최단경로라면 갱신해준다.
                        dist[vertex2] = weight2;
                        queue.add(new Node(vertex2, weight2));
                    }
                }
            }
        }
    }