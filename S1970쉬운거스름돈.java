import java.util.Scanner;

public class S1970쉬운거스름돈 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {

			int N = sc.nextInt();

			int a = N / 50000; // 50000

			int b; // 10000
			if (N >= 50000) {
				b = (N % 50000) / 10000;
			} else {
				b = N / 10000;
			}

			int c; // 5000
			if (N >= 10000) {
				c = (N % 10000) / 5000;
			} else {
				c = N / 5000;
			}

			int d; // 1000;
			if (N >= 5000) {
				d = (N % 5000) / 1000;
			} else {
				d = N / 1000;
			}

			int e; // 500;
			if (N >= 1000) {
				e = (N % 1000) / 500;
			} else {
				e = N / 500;
			}

			int f; // 100;
			if (N >= 500) {
				f = (N % 500) / 100;
			} else {
				f = N / 100;
			}

			int g; // 50;
			if (N >= 100) {
				g = (N % 100) / 50;
			} else {
				g = N / 50;
			}
			int h; // 10;
			if (N >= 50) {
				h = (N % 50) / 10;
			} else {
				h = N / 10;
			}

			System.out.println("#" + (i + 1));
			System.out.printf("%d %d %d %d %d %d %d %d", a, b, c, d, e, f, g, h);
			System.out.println();

		}
	}

}
