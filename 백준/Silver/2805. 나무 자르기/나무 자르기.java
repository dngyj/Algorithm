import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int need = sc.nextInt();
        int[] trees = new int[N];

        long max = -1;
        long min = 0;
        for(int i = 0; i<N;i++){
            trees[i] = sc.nextInt();
            max = Math.max(trees[i],max);
        }

        while(min<=max){
            long mid = (max+min)/2;
            long sum =0;
            for(int i=0; i<N;i++) {
                long temp = 0;
                temp = trees[i]-mid;
                if(temp<0) temp =0;
                sum += temp;
            }

            if(sum<need) max = mid-1;
            else min = mid+1;
        }

        System.out.println(max);
    }

}