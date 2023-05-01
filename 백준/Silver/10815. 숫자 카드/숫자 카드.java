import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int N,M;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		N = read();
		for(int i = 0; i < N; i++) {
			list.add(read());
		}
		Collections.sort(list);
		
		M = read();
		for(int i = 0; i < M; i++) {
			int cur = read();
			sb.append(binarySearch(cur)).append(' ');
		}
		
		System.out.println(sb);
	}
	
	static int binarySearch(int target) {
		int start = 0;
		int end = N-1;
		while(start<=end) {
			int mid = (start+end)/2;
			if(list.get(mid) == target) {
				return 1;
			}
			else if(list.get(mid) < target) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		return 0;
	}
	
	// 빠른 입력 메서드
	static int read() throws Exception{
		int n = 0;
		boolean isNumber = false;
		boolean isNegative = false;
		while(true) {
			int c = System.in.read();
			if(c<=32) {
				if(isNumber) return isNegative?(-1)*n:n;
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