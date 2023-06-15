import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt();

            int[] fibo1 = new int[41];
            int[] fibo2 = new int[41];

            fibo1[0] = 1;
            fibo1[1] = 0;
            fibo2[0] = 0;
            fibo2[1] = 1;

            for(int i=2; i<=N;i++){
                fibo1[i] = fibo1[i-1]+fibo1[i-2];
                fibo2[i] = fibo2[i-1]+fibo2[i-2];
            }
            System.out.println(fibo1[N]+" "+fibo2[N]);
        }
    }
}