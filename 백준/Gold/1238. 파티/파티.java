import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int N, M, X;
	static List<ArrayList<int[]>> adjList = new ArrayList<>();
	static int[] dist;
	static int[] dist2;
	public static void main(String[] args) throws Exception{
		N = read(); M = read(); X = read();
		dist = new int[N+1];
		dist2 = new int[N+1];
		for(int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			int V = read(); int E = read(); int C = read();
			adjList.get(V).add(new int[] {E,C});
		}
		
		for(int i = 1; i <=N; i++) {
			if(i!=X) {
				dijkstra2(i);
			}
		}
		
		dijkstra(X);
		
		int max = 0;
		for(int i = 1; i <=N; i++) {
			max = Math.max(max, dist[i] + dist2[i]);
		}
		//System.out.println(Arrays.toString(dist2));
		//System.out.println(Arrays.toString(dist));
		System.out.println(max);
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
			
		});
		
		for(int i = 0; i <= N; i++) {
			dist[i] = INF;
			if(i==start) dist[i] = 0;
		}
		
		pq.offer(new int[] {start, 0});
		int pick = 0;
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			//System.out.println(Arrays.toString(now));
			if(dist[now[0]] < now[1]) continue;
			pick++;
			if(pick == N) break;
			
			for(int i = 0; i < adjList.get(now[0]).size(); i++) {
				int[] cur = adjList.get(now[0]).get(i);
				if(dist[cur[0]] > dist[now[0]]+cur[1]) {
					dist[cur[0]] = dist[now[0]]+cur[1];
					pq.offer(new int[] {cur[0], dist[cur[0]]});
				}
			}
		}		
	}

	public static void dijkstra2(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
			
		});
		for(int i = 0; i <= N; i++) {
			dist[i] = INF;
			if(i==start) dist[i] = 0;
		}
		
		pq.offer(new int[] {start, 0});
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			//System.out.println(Arrays.toString(now));
			if(dist[now[0]] < now[1]) continue;
			if(now[0] == X) {
				dist2[start] = now[1];
				break;
			}
			for(int i = 0; i < adjList.get(now[0]).size(); i++) {
				int[] cur = adjList.get(now[0]).get(i);
				if(dist[cur[0]] > dist[now[0]]+cur[1]) {
					dist[cur[0]] = dist[now[0]]+cur[1];
					pq.offer(new int[] {cur[0], dist[cur[0]]});
				}
			}
		}		
	}
	
	// 비트 연산자를 이용하여 빨리 입력받는 메서드입니다.
	public static int read() throws Exception{
		int n = 0;
		boolean isNumber = false;
		boolean isNegative = false;
		while(true) {
			int c = System.in.read();
			if(c<=32) {
				if(!isNumber)continue;
				return isNegative?(-1)*n:n;
			}
			else if(c=='-') {
				isNegative = true;
			}
			else {
				if(!isNumber) isNumber=true;
				n = (n<<3) + (n<<1) + (c&15);
			}
		}
	}
}