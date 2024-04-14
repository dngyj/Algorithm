import java.util.Scanner;

public class Main {

    static int N;
    static int[] nums;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N];
        nums = new int[N];

        for(int i = 0;i<N;i++){
            nums[i] = sc.nextInt();
            dp[i] = 1;
        }

        for(int i=N-1;i>=0;i--){
            for(int j=N-1;j>i;j--){
                if(nums[i]>nums[j]) dp[i] = Math.max(dp[j]+1,dp[i]);
            }
        }

        int ans = -1;
        for(int i = 0;i<N;i++){
            ans = Math.max(dp[i],ans);
        }
        System.out.println(ans);
    }
}