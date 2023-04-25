import java.util.*;

public class Main {
	// n이 최대 100이며, 모든 노드는 1개의 부모만 가지고 있으므로 인접행렬을 선언할 수 있음
	static List<ArrayList<int[]>> adjList = new ArrayList<>();
	static boolean[] visited;
	static int N,r1,r2;
	static int start,find,min;
	public static void main(String[] args) throws Exception{
		N = read(); r1 = read(); r2 = read();
		min = Integer.MAX_VALUE;
		
		if(r1==r2) System.out.println(0);
		else {
			for(int i = 0; i <= N; i++) {
				adjList.add(new ArrayList<>());
			}
			visited = new boolean[N+1];
			
			for(int i = 0 ; i < N-1; i++) {
				int v = read();
				int e = read();
				int c = read();
				adjList.get(v).add(new int[] {e,c});
				adjList.get(e).add(new int[] {v,c});
			}
			
			visited[r1] = true;
			dfs(r1, 0, 0);
			
			System.out.print(min);
		}
	}
	
	static void dfs(int cur, int cost, int max) {
		if(cur == r2) {
			min = cost - max;
			return;
		}
		
		for(int i = 0; i < adjList.get(cur).size(); i++) {
			if(visited[adjList.get(cur).get(i)[0]]) continue;
			visited[adjList.get(cur).get(i)[0]] = true;
			dfs(adjList.get(cur).get(i)[0], cost+adjList.get(cur).get(i)[1], Math.max(max, adjList.get(cur).get(i)[1]));
		}
	}
	
	
	// 비트연산을 이용하여 입력을 빠르게 받는 메서드
	static int read() throws Exception{
		int n = 0;
		boolean isNumber = false;
		while(true) {
			int c = System.in.read();
			if(c<=32) {
				if(isNumber) return n;
				else continue;
			}
			else {
				isNumber = true;
				n = (n<<3) + (n<<1) + (c&15);
			}
		}
	}
}