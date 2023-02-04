import java.util.Arrays;
import java.util.Scanner;

public class S1984중간평균값구하기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {

			int[] num = new int[10];

			for (int j = 0; j < 10; j++) {
				num[j] = sc.nextInt();
			}
			Arrays.sort(num);

			int sum = 0;
			for (int j = 1; j < num.length - 1; j++) {
				sum += num[j];
			}

			System.out.printf("#%d %d\n", (i + 1), Math.round(sum / (double) 8));

		}
	}
}
