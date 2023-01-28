import java.util.Scanner;

public class S1284수도요금경쟁 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int P = sc.nextInt(); // A사 1리터당 요금
			int Q = sc.nextInt(); // B사 R리터 이하 요금
			int R = sc.nextInt(); // B사 기준 리터
			int S = sc.nextInt(); // B사 1리터당요금
			int W = sc.nextInt(); // 한달간 사용하는 수도의 양

			int costA = 0;
			int costB = 0;

			if (W > R) {
				costA = P * W;
				costB = Q + (W - R) * S;
			}
			if (W <= R) {
				costA = P * W;
				costB = Q;
			}

			System.out.print("#" + (i + 1) + " ");
			System.out.println(costA > costB ? costB : costA);

		}

	}

}
