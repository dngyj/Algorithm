import java.util.Scanner;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[][] arr = new int[9][9];


		for (int t = 0; t < T; t++) { // 테스트케이스

			int result = 1;

			// 배열 입력

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 행 숫자 체크

			for (int i = 0; i < 9; i++) {
				int[] std = new int[9]; // 기준 배열 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
				for (int j = 0; j < 9; j++) {

					std[arr[i][j] - 1] ++;
				}
				for (int r = 0; r < 9; r++) {
					if (std[r] == 0) {
						result = 0;
					}
				}
			}

			// 열 숫자 체크
			for (int i = 0; i < 9; i++) {
				int[] std = new int[9]; // 기준 배열 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
				for (int j = 0; j < 9; j++) {

					std[arr[j][i] - 1]++;
				}
				for (int c = 0; c < 9; c++) {
					if (std[c] == 0) {
						result = 0;
					}
				}
			}

			// 3*3 박스 체크

			for (int i = 0; i <= 6; i += 3) { // i : 0 3 6
				int[] std = new int[9];
				for (int j = 0; j <= 6; j += 3) { // j : 0 3 6

					int r = i + 3; // 3 6 9
					int c = j + 3; // 3 6 9

					for (int k = i; k < r; k++) { // 0 1 2/3 4 5/6 7 8
						for (int m = j; m < c; m++) { // 0 1 2/ 3 4 5/6 7 8
							std[arr[k][m] - 1]++;
						}
					}


					for (int s = 0; s < 9; s++) {
						if (std[s] == 0) {
							result = 0;
						}
					}

				}

			}

			System.out.printf("#" + (t + 1) + " " + result);
			System.out.println();
		}

	}

}
