import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static int N,M;
    static int[] nums;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        input();
        searchMin();
        System.out.println(min);
    }

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        nums= new int[N];
        for(int i = 0;i<N;i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
    }

    static void searchMin(){

        int left = 0;
        int right = 0;

        while(left<N&&right<N){
            if(nums[right]-nums[left]==M){
                min = M;
                return;
            }
            if(nums[right]-nums[left]>M){
                int diff = nums[right]-nums[left];
                min = Math.min(diff,min);
                left++;
            }
            if(nums[right]-nums[left]<M){
                right++;
            }
        }
    }
}