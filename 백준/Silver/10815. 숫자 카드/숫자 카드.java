import java.io.*;
import java.util.*;

public class Main{
	static int[] cards;
	
	public static void main(String[]args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		cards = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(now)).append(' ');
		}
		
		bw.write(sb.toString());
		bw.close();
	}
	
	static int binarySearch(int target) {
		int s = 0;
		int e = cards.length-1;
		
		while(s<=e) {
			int mid = (s+e)/2;
			
			if(cards[mid] == target) {
				return 1;
			}
	
			if(cards[mid] < target) s = mid + 1;
			else e = mid - 1;
		}
		
		return 0;
	}
}