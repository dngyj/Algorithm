import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[5];
		
		for(int i =0; i<5;i++) {
			num[i] = sc.nextInt();
		}
		
		int pow = 0;
		for(int i =0; i<5;i++) {
			pow+=Math.pow(num[i], 2);
		}
		int result = pow%10;
		
		System.out.println(result);
		
	}

}