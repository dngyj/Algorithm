import java.io.*;
import java.util.*;

public class Main {
	// n이 최대 100이며, 모든 노드는 1개의 부모만 가지고 있으므로 인접행렬을 선언할 수 있음
	static char[][] arr;
	static ArrayList<Integer> list = new ArrayList<>();
	static int r,c;
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		for(int i = 0; i < r; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < r; i++) {
			dfs(i, 0);
		}
		
		System.out.println(max);
	}
	
	static boolean dfs(int y, int x) {
		if(x == c-1) {
			max++;
			return true;
		}
		
		for(int i = -1; i<=1; i++) {
			if(y+i>=0 && y+i<r && arr[y+i][x+1] != 'x') {
				arr[y+i][x+1] = 'x';
				if(dfs(y+i, x+1)) return true;
			}
		}
		
		return false;
	}
}