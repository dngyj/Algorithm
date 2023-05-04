import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int s = 0;
		int e = N-1;
		long min = 2000000000;
		long total;
		long[] duo = {-1,-1};
		
		while(s<e) {
			total = arr[s]+arr[e];
			if(total==0) {
				duo[0] = arr[s];
				duo[1] = arr[e];
				break;
			}
			
			else if(total>0) {
				if(total-0<=min) {
					min = total;
					duo[0] = arr[s];
					duo[1] = arr[e];
				}
				e--;
			}
			
			else {
				if(0-total<=min) {
					min = -total;
					duo[0] = arr[s];
					duo[1] = arr[e];
				}
				s++;
			}
		}
		
		System.out.println(duo[0]+" "+duo[1]);
    }	
}