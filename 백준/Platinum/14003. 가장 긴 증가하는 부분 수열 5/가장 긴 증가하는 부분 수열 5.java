import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int[] idxs = new int[N];
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
                idxs[i] = length;
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
                idxs[i] = left;
            }
        }

//        for(int i = 0;i<N;i++){
//            System.out.print(idxs[i]+" ");
//        }

        Stack<Integer> stack = new Stack<>();

        int target = length;
        for(int i=N-1;i>=0;i--){
            if(idxs[i]==target){
                stack.push(nums[i]);
                target--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop()+" ");

        System.out.println(length+1);
        System.out.println(sb);
    }
}