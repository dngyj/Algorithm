public class Main {
	static int[] arr;
	static int[] LCM;
	public static void main(String[] args) throws Exception{
		int N = read();
		arr = new int[N+1];
		LCM = new int[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = read();
		}
		
		for(int i = 1; i <= N; i++) {
			LCM[i] = 1+dfs(i, arr[i]);
		}

		for(int i = 2; i <= N; i++) {
			LCM[i] = LCM[i] / euclid(LCM[i-1], LCM[i]) * LCM[i-1]; 
		}
		
		System.out.println(LCM[N]);
	}
	
	static int dfs(int start, int now) {
		if(start==now) {
			return 0;
		}
		
		return 1+dfs(start, arr[now]);
	}
	
	static int euclid(int a, int b) {
		if(b>a) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		while(b != 0) {
			int tmp = a%b;
			a = b;
			b = tmp;
		}
		return a;
	}
	
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