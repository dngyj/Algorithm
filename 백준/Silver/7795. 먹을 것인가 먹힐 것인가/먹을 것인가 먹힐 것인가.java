import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1; tc<=T;tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] arrA = new int[N];
            int[] arrB = new int[M];

            for(int i=0; i<N;i++){
                arrA[i] = sc.nextInt();
            }
            for(int i=0; i<M;i++){
                arrB[i] = sc.nextInt();
            }
            Arrays.sort(arrB);
            int result=0;

            for(int i=0; i<N;i++) {
                int st = 0; // 인덱스로 탐색한다. 시작
                int ed = M - 1; // 끝
                int index =0;

                while (st <= ed) {
                    int find = arrA[i]; //arrA 값 하나씩 탐색
                    int mid = (st + ed) / 2;
                    if (find <= arrB[mid]) { // 탐색값이 배열의 절반 아래면
                        ed = mid-1; // 끝값 조정
                    }else { // 탐색값이 배열 절반의 이상이라면
                        st = mid + 1; // 시작값 조정
                        index = mid + 1; // 인덱스는 결과를 저장하기 위한 값이다.
                    }
                }
                result += index;
            }
            System.out.println(result);
        }
    }
}