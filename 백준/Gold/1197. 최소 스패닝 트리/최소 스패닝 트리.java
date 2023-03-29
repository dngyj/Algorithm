import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	static int V, E;
	static int[] p;
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();  // 정점의 개수
		E = sc.nextInt(); // 간선의 개수
		
		int[][] info = new int[E][3]; 
		
		for(int i=0; i<E; i++) {
			info[i][0] = sc.nextInt(); // A번 정점
			info[i][1] = sc.nextInt(); // B번 정점
			info[i][2] = sc.nextInt(); // 가중치 간선
		}
		
		Arrays.sort(info, new Comparator<int[]>() { // 정렬하기 가중치 오름차순으로
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		p=new int[V+1]; 
		
		for(int i = 1; i<V;i++) { // 값넣기
			makeset(i);
		}
		
		long result = 0; // 최소 가중치 저장
		int pick =0; // 간선의 개수
		
		for(int i = 0; i<E;i++) {
			int x = info[i][0];
			int y = info[i][1];
			
			if(findset(x) != findset(y)) {
				union(x, y);
				result += info[i][2];
				pick++;
			}
			if(pick==(V-1)) break;
		}
		System.out.print(result);
		}
	
	private static void makeset(int i) {
		p[i] = i;
	}

	private static void union(int x, int y) {
		p[findset(y)] = p[findset(x)];
	}

	private static int findset(int x) {
		if(x!=p[x])
			p[x] = findset(p[x]);
		return p[x];
	}

}