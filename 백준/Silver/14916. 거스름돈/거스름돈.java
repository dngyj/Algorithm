import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int coin = sc.nextInt();
		int result = -1;
		int min = Integer.MAX_VALUE;

		for (int r1 = 0 ; r1 <=coin / 5; r1++) {
			for (int r2 = 0; r2 <= coin / 2 + 1; r2++) {
				if (coin == 5 * r1 + 2 * r2) {
					result = r1 + r2;
				}
			}
		}
		System.out.println(result);
	}

}