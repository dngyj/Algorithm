public class Main {
	
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		N = read(); dp = new int[N+1];
		int max = 0;
		dp[1] = read();
		if(N == 1) {
			System.out.println(1);
			return;
		}
		for(int i = 2; i <= N; i ++) {
			dp[i] = Integer.MAX_VALUE;
			int now = read();
			max = Math.max(binarySearch(now, i), max);
		}
		
		System.out.println(max);
		
	}
	
	static int binarySearch(int now, int bound) {
		int ans = 0;
		int s = 1;
		int e = bound;
		while(s<=e) {
			int mid = (s+e)/2;
			if(dp[mid] < now) {
				ans = mid;
				s = mid+1;
			}
			else {
				e = mid-1;
			}
		}
		dp[ans+1] = now;
		return ans+1;
	}
	
	// 빠른 입력 메서드
	static int read() throws Exception{
		int n = 0;
		boolean isNegative = false;
		boolean isNumber = false;
		
		while(true) {
			int c = System.in.read();
			if(c <= 32) {
				if(isNumber) return isNegative?(-1)*n:n;
				else continue;
			}
			
			else if(c == '-') {
				isNegative = true;
			}
			
			else {
				if(!isNumber) isNumber = true;
				n = (n<<3) + (n<<1) + (c&15);
			}
		}
	}
	
}