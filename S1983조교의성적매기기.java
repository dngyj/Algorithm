import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class S1983조교의성적매기기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

		for (int i = 0; i < t; i++) { // 테스트 케이스의 수만큼 반복

			int N = sc.nextInt();
			int K = sc.nextInt();

			Double[] score = new Double[N];

			int score1 = 0;
			int score2 = 0;
			int score3 = 0;
			Double k_score = 0.0;

			for (int j = 0; j < N; j++) { // 학생 수만큼 반복

				score1 = sc.nextInt();
				score2 = sc.nextInt();
				score3 = sc.nextInt();
				score[j] = score1 * 0.35 + score2 * 0.45 + score3 * 0.20;

				if (j + 1 == K) {
					k_score = score[j];
				}
			}

			Arrays.sort(score, Comparator.reverseOrder());


			int index = 0;

			for (int m = 0; m < N; m++) {
				if (score[m] == k_score) {
					index = m;
				}
			}
			index = index / (N / 10);

			System.out.printf("#%d %s\n", (i + 1), grade[index]);

		}

	}

}
