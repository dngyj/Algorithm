import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static class Node implements Comparable<Node>{ // 노드 클래스 만들기
		int v, w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}		
	}
	
	static List<ArrayList<Node>> graph = new ArrayList<>();
	static int[] dist;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int V = readInt();
		int E = readInt();
		for(int i = 0; i < V+1; i++) 
			graph.add(new ArrayList<>()); // 1~V까지
		int start = readInt();
		for(int i = 0; i < E; i++) {
			int A = readInt();
			int B = readInt();
			int C = readInt();
			graph.get(A).add(new Node(B,C));
		}
		
		dist = new int[V+1];
		
		dijkstra(start, V);
		
		for(int i = 1; i < V+1; i++) {
			if(dist[i] == INF) sb.append("INF").append('\n');
			else sb.append(dist[i]).append('\n');
		}
		
		bw.write(sb.toString());
		bw.close();
	}
	
	static void dijkstra(int start, int V) {
		for(int i = 1; i < V+1; i++) {
			dist[i] = INF; // 초기화
		}
		pq.offer(new Node(start,0));
		dist[start] = 0;
		int pick = 0;
		while(!pq.isEmpty()){
			Node node = pq.poll();
			
			if(dist[node.v] < node.w) continue;
			pick++;
			if(pick == V) break;
			
			for(int i = 0; i < graph.get(node.v).size(); i++) {
				Node curr = graph.get(node.v).get(i);
				if(dist[curr.v]>dist[node.v]+curr.w){
					dist[curr.v] = dist[node.v] + curr.w;
					pq.offer(new Node(curr.v, dist[curr.v]));
				}
			}
		}
	}
    
    static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input<=32)
                return isNegative ? n * -1 : n;
            else if(input=='-')
                isNegative = true;
            else
                n = (n<<3) + (n<<1) + (input&15);
        }
    }
}