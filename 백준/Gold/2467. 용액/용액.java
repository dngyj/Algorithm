
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] waters = new int[N];
        for(int i =0;i<N;i++){
            waters[i] = sc.nextInt();
        }

        int left = 0;
        int right = N-1;
        int ans1 = 0;
        int ans2 = 0;
        int min = Integer.MAX_VALUE;
        int dist;
        while(left<right){
            dist = waters[right]+waters[left];
            int Dist = Math.abs(dist);
            if(Dist < min){
                min = Dist;
                ans1 = waters[left];
                ans2 = waters[right];
            }
            if(dist>0) right--;
            else left++;
        }
        System.out.println(ans1 +" "+ ans2);
    }
}