import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int need = sc.nextInt();

        int[] trees = new int[N];

        long max = Integer.MIN_VALUE;

        for(int i = 0; i<N;i++){
            trees[i] = sc.nextInt();
            max = Math.max(trees[i],max);
        }

        max++;

        long mid = 0;
        long min = 0;

        while(min<max){

            mid = (max+min)/2;

            long sum =0;
            for(int i=0; i<N;i++) {
                long temp = 0;
                temp = trees[i]-mid;
                if(temp<0) temp =0;
                sum += temp;
            }

            if(sum<need) max = mid;
            else min = mid+1;
        }

        System.out.println(max-1);
    }

}