import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 1; i<=N;i++) {
			for(int j=N-i;j>0;j--) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 1; i<N;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(" ");
			}
			for(int j=2*(N-i+1)-3 ;j>=1;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}

}