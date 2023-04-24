import java.util.*;

public class Main {
	// n이 최대 100이며, 모든 노드는 1개의 부모만 가지고 있으므로 인접행렬을 선언할 수 있음
	static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	static boolean[] visited;
	static ArrayList<Integer> list = new ArrayList<>();
	static int n;
	public static void main(String[] args) throws Exception{
		n = read();
		for(int i = 0; i<= n; i++) {
			adjList.add(new ArrayList<>());
		}
		visited = new boolean[n+1];
		for(int i = 1 ; i <= n; i++) {
			adjList.get(read()).add(i);
		}
		
		for(int i = 1; i <= n; i++) {
			Arrays.fill(visited, false);
			for(int now : adjList.get(i)) {
				if(!visited[now]) {
					visited[now] = true;
					dfs(i, now, 1);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	static void dfs(int start, int cur, int size) {
		if(start == cur) {
			visited[cur] = true;
			list.add(start);
			return;
		}
		for(int now : adjList.get(cur)) {
			if(visited[now]) return;
			visited[now] = true;
			dfs(start, now, size+1);
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