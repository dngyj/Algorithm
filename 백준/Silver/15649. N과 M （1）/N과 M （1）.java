import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] selected;
	static boolean[] flag;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new int[M+1];
		flag = new boolean[N+1];
		
		function(1);
		System.out.println(sb.toString());
	}
	
	static void function(int a) {
		if(a ==M+1) { // a가 원소 끝에 꽉차면
			for(int i =1;i<=M;i++) sb.append(selected[i]).append(" ");
			sb.append("\n");
			//selected 원소 1부터 M까지 출력하기
		}
		else { // 아니라면 
		//	1 부터 N까지 돌면서
			for(int ele = 1; ele<=N; ele++) {
				if(!flag[ele]) {
					selected[a] = ele;
					flag[ele] = true;
					function(a+1);
					flag[ele] =false;
				}

			}
		}
	}
	
}
