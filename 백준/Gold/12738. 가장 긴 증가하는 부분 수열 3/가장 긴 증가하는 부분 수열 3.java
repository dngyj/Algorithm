import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N+1];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1;i<N+1;i++) nums[i] = sc.nextInt();

        list.add(Integer.MIN_VALUE);

        for(int i = 1;i<N+1;i++){
            int point = nums[i];
            int left = 1;
            int right = list.size()-1;

            if(point>list.get(list.size()-1)) list.add(point);
            else{
                while(left<right){
                    int mid = (left+right)/2;
                    if(point>list.get(mid)) left = mid+1;
                    else right = mid;
                }
                list.set(left, nums[i]);
            }
        }
        System.out.println(list.size()-1);
    }
}