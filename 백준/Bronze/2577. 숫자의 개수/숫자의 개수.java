import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		
		int[] count = new int[10];
		
		int mul = A*B*C;
		String num = String.valueOf(mul);
	
		
		for(int i =0; i<num.length();i++) {
			count[num.charAt(i)-48]++;
		}
		for(int i =0; i<10;i++) {
			System.out.println(count[i]);
		}
	}

}