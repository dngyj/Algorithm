import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int[] LIS = new int[N];
        for(int i = 0;i<N;i++){
            nums[i] = sc.nextInt();
        }
        LIS[0] = nums[0];
        int length = 0;

        for(int i = 1;i<N;i++){

            if(nums[i]>LIS[length]){
                length++;
                LIS[length] = nums[i];
            }
            else{
                int left = 0;
                int right = length;
                while(left<right){
                    int mid = (left+right)/2;
                    if (nums[i] > LIS[mid]) {
                        left = mid+1;
                    }
                    else{
                        right = mid;
                    }
                }
                LIS[left] = nums[i];
            }
        }
        System.out.println(length+1);
    }


}