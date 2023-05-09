import java.util.*;

public class Main {
	static int N,K;
	static int[] visited = new int[100001];
	public static void main(String[] args) throws Exception{
		N = read(); K = read();
		Arrays.fill(visited, -1);
		System.out.println(bfs(N));
		find();
	}
	
	// 가장 빠른 도달점을 찾는 BFS
	public static int bfs(int start) {
		int time = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = -2;
		while(!queue.isEmpty()) {
			int counter = queue.size();
			for(int i = 0; i < counter; i++) {
				int now = queue.poll();
				if(now==K) return time;
				if(now-1>=0 && visited[now-1]==-1) {
					visited[now-1] = now;
					queue.offer(now-1);
				}
				if(now+1<=100000 && visited[now+1]==-1) {
					visited[now+1] = now;
					queue.offer(now+1);
				}
				if(now*2<=100000 && visited[now*2]==-1) {
					visited[now*2] = now;
					queue.offer(now*2);
				}
			}
			time++;
		}
		
		return time;
	}
	
	// 역추적 메서드
	public static void find() {
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		stack.push(K);
		int now = K;
		while(true) {
			now = visited[now];
			if(now == -2) break;
			stack.push(now);
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(' ');
		}
		
		System.out.println(sb);
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