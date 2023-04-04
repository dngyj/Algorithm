import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] contain = new int[N];

		for (int i = 0; i < N; i++) {
			contain[i] = sc.nextInt();
		}
		
		Arrays.sort(contain);
		
		int M = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int T = sc.nextInt();
			
			if(binarySearch(contain, T) >= 0) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}

	private static int binarySearch(int[] contain, int key) {
		int st =0;
		int ed = contain.length-1;
		
		while(st<=ed) {
			int mid = (st+ed)/2;
			
			if(key<contain[mid]) {
				ed = mid-1;
			}
			else if(key>contain[mid]) {
				st=mid+1;
			}
			else return mid;
		}
		return -1;
	}
}