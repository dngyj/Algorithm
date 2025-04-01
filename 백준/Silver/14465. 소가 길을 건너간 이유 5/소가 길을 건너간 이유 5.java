import java.util.Scanner;

public class Main {

    static int N,K,B;
    static int[] signals;

    public static void main(String[] args) {
        input();
        slidingWindow();
    }

    static void slidingWindow(){
        int broken = 0;
        for(int i = 1; i<=K; i++){
            if(signals[i]==-1) broken++; 
        }
        int repair_count = broken;
        for(int i = K+1; i<=N; i++){
            if(signals[i] == -1) broken++;
            if(signals[i-K]==-1) broken--;
            repair_count = Math.min(broken, repair_count);
        }
        System.out.println((repair_count));
    }

    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        B = sc.nextInt();
        signals = new int[N+1];
        for(int b = 0; b<B; b++){
            int broken = sc.nextInt();
            signals[broken] = -1;
        }
    }
}