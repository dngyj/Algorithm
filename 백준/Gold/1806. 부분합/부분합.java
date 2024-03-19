import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] nums = new int[N+1];
        for(int i = 0;i<N;i++){
            nums[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(left<=N&&right<=N){
            if(sum>=S&&min>right-left) min = right-left;
            if(sum<S) sum += nums[right++];
            else sum -= nums[left++];
        }
        if(min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}