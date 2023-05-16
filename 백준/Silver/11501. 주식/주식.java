import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){

            int N = sc.nextInt();
            int[] price = new int[N];

            for(int i=0; i<N;i++){
                price[i] = sc.nextInt();
            }

            long result =0;
            long max = price[N-1];

            for(int i=N-1; i>=0; i--){
                if(price[i]<max) {
                    result += max- price[i];
                }
                else max = price[i];
            }
            System.out.println(result);
        }
    }
}