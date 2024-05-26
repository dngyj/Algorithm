import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] honey = new int[N];
        int[] sum = new int[N];
        int[] rsum = new int[N];

        for(int i = 0;i<N;i++){
            honey[i] = sc.nextInt();
        }
        sum[0] = honey[0];
        rsum[N-1] = honey[N-1];
        
        for(int i = 1;i<N;i++){
            sum[i] = honey[i]+sum[i-1];
        }
        for(int i = N-1;i>0;i--){
            rsum[i-1] = honey[i-1] + rsum[i];
        }

        int case1 = -1; //바구니 가장 오른
        int case2 = -1; // 바구나 가장 왼
        int case3 = -1; // 바구니 가운데
        int max1 = -1;
        int max2 = -1;
        int max3 = -1;

        for(int point = 1; point<N-1; point++){
            case1 = (sum[N-1]-sum[0])+(sum[N-1]-sum[point])-(sum[point]-sum[point-1]);
            case2 = (rsum[0]-rsum[N-1])+(rsum[0]-rsum[point])-(rsum[point]-rsum[point+1]);
            case3 = (sum[point]-sum[0])+(rsum[point]-rsum[N-1]);
            max1 = Math.max(max1,case1);
            max2 = Math.max(max2,case2);
            max3 = Math.max(max3,case3);
        }
        int max = Math.max(max1,Math.max(max2,max3));
        System.out.println(max);
    }
}