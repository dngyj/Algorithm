public class Main {
	// n이 최대 100이며, 모든 노드는 1개의 부모만 가지고 있으므로 인접행렬을 선언할 수 있음
	static boolean[][] adjArr;
	static boolean[] visited;
	static int n,m,ans;
	static int start,find;
	public static void main(String[] args) throws Exception{
		n = read();
		adjArr = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		start = read();
		find = read();
		m = read();
		for(int i = 0 ; i < m; i++) {
			int v = read();
			int e = read();
			adjArr[v][e] = true;
			adjArr[e][v] = true;
		}
		visited[start] = true;
		dfs(start,0);
		
		System.out.print(-1);
	}
	
	static void dfs(int start, int chon) {
		if(start == find) {
			System.out.println(chon);
			System.exit(0);
		}
		
		for(int i=1; i<=n; i++) {
			if(adjArr[start][i]&&!visited[i]) {
				visited[i] = true;
				dfs(i, chon+1);
			}
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