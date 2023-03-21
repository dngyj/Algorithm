import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br;

	static String endl = "\n";
	static String blank = " ";
	
	// n개 중 k개를 뽑아 합이 s가 되는 경우의 수 구하기
	static int n;
	static int s;
	static int[] num;
	static int[] arr;
	static int cnt;
	static int len;

	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		stk();
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		num = new int[n];
		stk();
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void recur(int cur, int start) {
		int sum = 0;
		if (cur == len) {
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			if (sum == s) {
				cnt += 1;
			}
			return;
		}
		for (int i = start; i < n; i++) {
			arr[cur] = num[i];
			recur(cur + 1, i + 1);
		}
	}
	
	static void pro() throws IOException {
		cnt = 0;
		for (len = 1; len <= n; len++) {
			arr = new int[len];
			recur(0, 0);
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
