import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] pies = new int[N];
        for(int i = 0; i<N; i++){
            pies[i] = sc.nextInt();
        }
        int max_flavor = 0;
        for(int i = 0; i<K; i++){
            max_flavor += pies[i];
        }
        int flavor = max_flavor;

        for(int i = 0; i<N; i++){
            flavor -= pies[i];
            flavor += pies[(i+K)%N];
            max_flavor = Math.max(max_flavor, flavor);
        }
        System.out.println(max_flavor);
    }
}