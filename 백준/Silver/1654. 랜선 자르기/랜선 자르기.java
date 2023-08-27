import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        int[] lengths = new int[K];

        long max = Integer.MIN_VALUE;

        for(int i = 0; i<K;i++){
            lengths[i] = sc.nextInt();
            max = Math.max(max, lengths[i]);
        }
        
        max++;
        
        long min = 0;
        long mid = 0;

        while(min<max){
            mid = (max+min)/2;

            long ea = 0;
            for(int i=0;i<K;i++){
                ea += lengths[i]/mid;
            }

            if(ea<N) max = mid;
            else min = mid+1;
        }


        System.out.println(min-1);

    }

}