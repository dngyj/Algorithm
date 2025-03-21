import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i<N; i++){
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        dp[0]=0;
        for(int i = 1; i<N; i++){
            for(int k = 0; k<i; k++){
                if(nums[i]>nums[k]){
                    dp[i] = Math.max(dp[i],dp[k]+1);
                }
            }
        }
        int max = -1;
        for(int i = 0; i<N; i++){
            max = Math.max(dp[i], max);
        }
        int answer = N - max - 1;
        System.out.println(answer);
    }
}