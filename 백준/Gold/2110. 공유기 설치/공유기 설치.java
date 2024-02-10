import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] loc = new int[N];
        int left = 0;
        int right = 0;
        for(int i =0;i<N;i++){
            loc[i] = sc.nextInt();
        }
        Arrays.sort(loc);
        left = 1;
        right = loc[N-1];

        while(left<=right){
            int mid = (left+right)/2;
            int cnt = 1;
            int last = loc[0];
            for(int i = 1;i<N;i++){
                if(loc[i]-last >= mid){
                    cnt++;
                    last = loc[i];
                }
            }
            if(cnt<C) right = mid-1;
            else left = mid+1;
        }
        System.out.println(right);
    }
}