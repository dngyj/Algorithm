import java.util.Scanner;

public class S1204최빈수구하기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {

			int t = sc.nextInt();

			int[] scoreArr = new int[1000];
			int[] count = new int[101];

			for (int j = 0; j < 1000; j++) {
				int score = sc.nextInt();
				scoreArr[j] = score;
				count[score] += 1;
			}

			int result = 0;
			int max = 0;

//			for (int j = 0; j < 100; j++) {
			for (int j = 100; j >= 0; j--) {

				if (count[j] > max) {
					max = count[j];
					result = j;
				}
			}
			System.out.printf("#%d %d", t, result);
			System.out.println();

		}

	}

}
