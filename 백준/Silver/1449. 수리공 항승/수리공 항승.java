import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 물이 새는 곳의 개수
        int L = sc.nextInt(); // 테이프의 길이

        int[] leak = new int[N];

        for(int i=0; i<N;i++) {
            leak[i] = sc.nextInt();
        }
        Arrays.sort(leak);

        double tape = leak[0] - 0.5;

        int cnt = 1;
        for(int i =0; i<N;i++){
            if(tape+L<leak[i]){
                cnt++;
                tape = leak[i] - 0.5;
            }
        }
        System.out.println(cnt);
    }

}