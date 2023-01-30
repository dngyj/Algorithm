import java.util.Scanner;

public class S1976시각덧셈 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int h1 = sc.nextInt();
			int m1 = sc.nextInt();
			int h2 = sc.nextInt();
			int m2 = sc.nextInt();

			int Hsum = 0;
			int Msum = 0;

			if (m1 + m2 >= 60) {
				Msum = m1 + m2 - 60;
				Hsum = h1 + h2 + 1;
				if (Hsum > 12) {
					Hsum = Hsum - 12;
				}
			} else {
				Msum = m1 + m2;
				Hsum = h1 + h2;
				if (Hsum > 12) {
					Hsum = Hsum - 12;
				}
			}

			System.out.printf("#%d %d %d", i + 1, Hsum, Msum);
			System.out.println();
		}

	}

}
