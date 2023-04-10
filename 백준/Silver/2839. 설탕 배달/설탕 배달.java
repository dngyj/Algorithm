import java.util.Scanner;

public class Main{

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 0;
		int min = N;
		int cnt = 0;
		
		for(int i =0; i<=N;i++) {
			for(int j=0;j<=N;j++) {
				if(3*i+5*j == N) {
					result = i+j;
					cnt++;
					if(result<min) {
						min = result;
					}
				}

			}
		}
		if(cnt==0) {
			System.out.println(-1);
		}
		else System.out.println(min);
	}
}
