import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] arr = new int[N][2];
		
		for(int r=0; r<N;r++) {
			for(int c =0; c<=1;c++) {
				arr[r][c]= sc.nextInt();
			}
		}
		
		//Arrays.sort(arrays, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		
		Arrays.sort(arr, new Comparator<int[]>() {
			  @Override
			  public int compare(int[] o1, int[] o2) {
			    if (o1[0] == o2[0])
			      return o1[1] - o2[1];
			    else
			      return o1[0] - o2[0];
			  }
			});
		
		for(int r=0; r<N;r++) {
			for(int c =0; c<=1;c++) {
				System.out.print(arr[r][c]+" ");
			}
			System.out.println();
		}
	}

}