import java.util.*;

public class Main {
	static int N, K;
	static int[] time;
	static int[] prefix;
	static List<ArrayList<Integer>> adjList = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		int T = read();
		for(int i = 0; i < T; i++) {
			N = read(); K = read();
			for(int j = 0; j <= N; j++) {
				adjList.add(new ArrayList<>());
				// N개의 건물에 대해서 inDegree 인접 리스트를 선언
			}
			time = new int[N+1];
			// 각 건물의 단독 건설 시간
			prefix = new int[N+1];
			// 각 건물의 이어지는 건설 시간
			for(int j = 1; j <= N; j++) {
				time[j] = read();
			}

			for(int j = 0; j < K; j++) {
				int V = read();
				int E = read();
				adjList.get(E).add(V);
				// inDegree
			}
			
			tp();
			
			System.out.println(prefix[read()]);
		}
	}
	
	public static void tp() {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <=N; i++) {
			if(adjList.get(i).size() == 0) {
				prefix[i] = time[i];
				queue.offer(i);
				// size()가 0이면 queue에 넣고, inDegree가 없으면 time=prefix.
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int i = 1; i <=N; i++) {
				if(adjList.get(i).contains(cur)) {
					adjList.get(i).remove((Integer)cur);
					prefix[i] = Math.max(prefix[i], prefix[cur]+time[i]);
					if(adjList.get(i).size() == 0) queue.offer(i);
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
				if(!isNumber) continue;
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