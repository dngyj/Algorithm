import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] moneys = new int[N];
        int left = 0;
        int right = 0;
        for(int i =0;i <N;i++){
            moneys[i] = sc.nextInt();
            left = Math.max(left, moneys[i]);
            right += moneys[i];
        }
        int cnt;
        int sum;
        while(left<=right){
            int mid = (left+right)/2;
            sum = 0;
            cnt = 1;

            for(int i =0;i<N;i++){
                sum +=moneys[i];
                if(sum>mid){
                    sum = moneys[i];
                    cnt++;
                }
            }
            if(cnt>M) left = mid +1;
            else right= mid -1;
        }
        System.out.println(left);
    }
}