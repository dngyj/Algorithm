public class Main {
	public static void main(String[] args) throws Exception{
		int n = read();
		int m = read();
		System.out.println(Math.abs((long)n-m));
	}
	
	// 비트연산을 이용하여 입력을 빠르게 받는 메서드
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