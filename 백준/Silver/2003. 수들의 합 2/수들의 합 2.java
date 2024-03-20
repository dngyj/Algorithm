import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[N+1];
        for(int i = 0; i<N;i++){
            nums[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;

        while(left<=N&&right<=N){
            if(sum==M) {
                cnt++;
                sum += nums[right++];
            }
            if(sum<M) sum += nums[right++];
            if(sum>M) sum -= nums[left++];
        }
        System.out.println(cnt);
    }
}