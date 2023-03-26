import java.util.Scanner;

public class Main {

	static int N;
	static int[] arr;
	static int[] sorted;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		N = sc.nextInt(); // 수의 개수
		arr = new int[N];
		sorted = new int[N];
		
		for(int i =0; i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		mergeSort(arr, 0, N-1);
		
		for(int i = 0; i<N;i++)
			sb.append(arr[i]).append("\n");
		
			System.out.print(sb.toString());
		
		
	}

	private static void mergeSort(int[] arr, int left, int right) {
		
		if(left<right) {
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
			int L = left;
			int R = mid + 1;
			int idx = left;
			
			while(L<=mid && R<= right) {
				if(arr[L]<=arr[R]) {
					sorted[idx++] = arr[L++];
				}
				else
					sorted[idx++] = arr[R++];
			}
			
			if(L<= mid) {
				for(int i = L;i<=mid;i++) {
					sorted[idx++] = arr[i];
				}
			}
			else
				for(int i = R;i<=right;i++) {
					sorted[idx++] = arr[i];
			}
			
			for (int i = left; i <= right; i++)
				arr[i] = sorted[i];
			
	}

}