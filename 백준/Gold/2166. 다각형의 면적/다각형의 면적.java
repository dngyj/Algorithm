import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N;
    static long[] x;
    static long[] y;
    static String ans;

    public static void main(String[] args) {
        input();
        shoelace();
        System.out.println(ans);
    }
    
    static void input(){
        N = sc.nextInt();
        x = new long[N+1];
        y = new long[N+1];
        for(int i =0;i<N;i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        x[N] = x[0];
        y[N] = y[0];
    }

    static void shoelace(){
        long sum_a = 0, sum_b = 0;
        for (int i = 0; i < N; i++) {
            sum_a += x[i] * y[i + 1];
            sum_b += x[i + 1] * y[i];
        }
        ans = String.format("%.1f", (Math.abs(sum_a - sum_b) / 2.0));
    }
}