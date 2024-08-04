import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[] snacks;
    static long answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        snacks = new int[M];
        for(int i = 0; i<M;i++){
            snacks[i] = sc.nextInt();
        }
        Arrays.sort(snacks);
        long left = 1;
        long right = snacks[M-1];

        while(left<=right){
            long mid = (left+right)/2;
            int count = 0;
            for(int i = 0; i<M;i++){
                count += snacks[i] / mid;
            }
            if(count>=N){
                answer = Math.max(answer, mid);
                left = mid+1;
            }
            else right = mid-1;
        }
        System.out.println(answer);
    }
}