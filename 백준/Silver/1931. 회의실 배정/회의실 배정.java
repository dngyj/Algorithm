import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] time = new int[N][2];

        for(int n=0;n<N;n++){
            time[n][0] = sc.nextInt(); //시작시간
            time[n][1] = sc.nextInt(); //종료시간
        }

        Arrays.sort(time, (o1, o2) -> {
            if(o1[1]==o2[1]) { // 종료시간이 같다면 시작시간 빠른순으로 정렬한다.
                return o1[0] - o2[0];
            }
            return o1[1]-o2[1];
        });

        int cnt=0;
        int end = 0;

        for(int i=0;i<N;i++){
            if(end<=time[i][0]){ //만약 종료시간이 비교할 시작시간보다 작거나 같다면
                cnt++;
                end = time[i][1]; //종료시간 새로 초기화
            }
        }
        System.out.println(cnt);
    }

}