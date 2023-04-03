import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		
		while(sc.hasNext()) {
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.println(A+B);
		}
	}
}