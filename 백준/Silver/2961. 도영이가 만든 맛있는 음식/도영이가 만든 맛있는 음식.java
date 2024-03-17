import java.util.Scanner;

public class Main {

    static int N;
    static int[] S;
    static int[] B;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = new int[N];
        B = new int[N];
        for(int i = 0;i<N;i++){
            S[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }
        make(0,0,1,0);
        System.out.println(ans);
    }
    static void make(int cnt, int depth, int mutipleS, int plusB){
        if(depth == N){
            if(cnt != 0) ans = Math.min(ans, Math.abs(mutipleS-plusB));
            return;
        }
        make(cnt,depth+1,mutipleS,plusB);
        make(cnt+1,depth+1,mutipleS*S[depth], plusB+B[depth]);
    }
}