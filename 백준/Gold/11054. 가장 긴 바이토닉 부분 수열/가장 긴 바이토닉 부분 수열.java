import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        int[] dp = new int[N];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        for(int i = 0 ;i<N;i++){
            nums[i] = sc.nextInt();
        }
        for(int i = 0;i<N;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) dp1[i] = Math.max(dp1[i],dp1[j]+1);
            }
        }
        for(int i = N-1;i>=0;i--){
            for(int j=N-1;j>i;j--){
                if(nums[i]>nums[j]) dp2[i] = Math.max(dp2[i],dp2[j]+1);
            }
        }
        int ans = -1;
        for(int i = 0;i<N;i++){
            dp[i] = dp1[i]+dp2[i];
            ans = Math.max(dp[i],ans);
        }
        System.out.println(ans-1);
    }
}