import java.util.*;

public class Main {
	static final int INF = 200000000;
	static int N,E, 경유지1, 경유지2, order;
	static int[][] dist;
	static int[][] adjArr;
	public static void main(String[] args) throws Exception {
		N = read(); E = read();
		dist = new int[3][N+1];
		adjArr = new int[N+1][N+1];
		
		for(int i = 0; i < E; i++) {
			int v = read();
			int e = read();
			int c = read();
			adjArr[v][e] = c;
			adjArr[e][v] = c;
		}
		
		경유지1 = read();
		경유지2 = read();
		
		dijkstra(1);
		dijkstra(경유지1);
		dijkstra(경유지2);
		
		int min = INF;
		int a = dist[0][경유지1]+dist[1][경유지2]+dist[2][N];
		int b = dist[0][경유지2]+dist[1][N]+dist[2][경유지1];
		min = Math.min(min, Math.min(a, b));
		System.out.println(min == INF ? -1 : min);

	}
	
	static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
			
		});
		for(int i = 1; i <= N; i++) {
			dist[order][i] = INF;
		}
		pq.offer(new int[] {start,0});
		dist[order][start] = 0;
		
		int pick = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(dist[order][cur[0]] < cur[1]) continue;
			pick++;
			if(pick == N) break;
			for(int i = 1; i <= N; i++) {
				if(adjArr[cur[0]][i] == 0) continue;
				if(dist[order][i] > dist[order][cur[0]] + adjArr[cur[0]][i]) {
					dist[order][i] = dist[order][cur[0]] + adjArr[cur[0]][i];
					pq.offer(new int[] {i, dist[order][i]});
				}
			}
		}
		
		order++;
	}
	
	static int read() throws Exception {
		int n = 0;
		boolean isNumber = false;
		boolean isNegative = false;
		while(true) {
			int input = System.in.read();
			if(input <= 32) {
				if(isNumber) return isNegative ? (-1 * n) : n;
				else continue;
			}
			else if(input == '-') {
				isNegative = true;
			}
			else {
				isNumber = true;
				n = (n<<3) + (n<<1) + (input&15);
			}
		}
	}
}