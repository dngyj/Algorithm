import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] ground;
    static int[] sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        ground = new int[N+1];
        sum = new int[N+2];
        for(int i =1;i<N+1;i++){
            ground[i] = sc.nextInt();
        }
        for(int i = 0;i<M;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int k = sc.nextInt();
            sum[st] +=k;
            sum[ed+1] -=k;
        }
        for(int i =1;i<=N;i++){
            sum[i] += sum[i-1];
            ground[i] +=sum[i];
        }
        for(int i =1;i<=N;i++){
            System.out.print(ground[i]+" ");
        }

    }

}