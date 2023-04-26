import java.util.*;

public class Main {
	static boolean[][] adjArr;
	static int[][] queries;
	static boolean[] visited;
	static int N, nodes;

	public static void main(String[] args) throws Exception{
		N = read();
		adjArr = new boolean[N+1][N+1];
		queries = new int[N+1][2];
		visited = new boolean[N+1];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int type = read();
			if(type==1) {
				queries[++nodes] = new int[] {read(), read()};
				for(int j = 1; j < nodes; j++) {
					if((queries[j][0] > queries[nodes][0]) && (queries[j][0] < queries[nodes][1])) {
						adjArr[j][nodes] = true;
					}
					if((queries[j][1] > queries[nodes][0]) && (queries[j][1] < queries[nodes][1])) {
						adjArr[j][nodes] = true;
					}
					
					if((queries[nodes][0] > queries[j][0]) && (queries[nodes][0] < queries[j][1])) {
						adjArr[nodes][j] = true;
					}
					if((queries[nodes][1] > queries[j][0]) && (queries[nodes][1] < queries[j][1])) {
						adjArr[nodes][j] = true;
					}
				}
			}else {
				Arrays.fill(visited, false);
				int start = read();
				visited[start] = true;
				dfs(start);
				if(visited[read()]) sb.append(1).append('\n');
				else sb.append(0).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int start) {
		for(int i=1; i<=nodes; i++) {
			if(start==i) continue;
			if(adjArr[start][i]&&!visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
	
	
	// 비트연산을 이용하여 입력을 빠르게 받는 메서드
	static int read() throws Exception{
		int n = 0;
		boolean isNumber = false;
		boolean isNegative = false;
		while(true) {
			int c = System.in.read();
			if(c<=32) {
				if(isNumber) return isNegative?n*(-1):n;
				else continue;
			}
			else if(c=='-') {
				isNegative = true;
			}
			else {
				isNumber = true;
				n = (n<<3) + (n<<1) + (c&15);
			}
		}
	}
}