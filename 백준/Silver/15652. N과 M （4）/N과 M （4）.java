import java.util.Scanner;

public class Main {

	static int N;
	static int M;
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
		if(a == M+1) {
			for(int i = 1; i<=M;i++)
				sb.append(selected[i]).append(" ");
			sb.append("\n");
		}
		else {
			for(int ele = 1; ele<=N;ele++) {
				flag[ele] = false;
				if(ele<selected[a-1]) {
					flag[ele]=true;
				}
				if(!flag[ele]) {
					selected[a] = ele;
					function(a+1);
				}
			}
		}
	}

	
	
	
}