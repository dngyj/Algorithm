import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] bottomSum;
    static int[] upSum;
    static int[] prefixSum;
    static int N,H;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        H = sc.nextInt();
        bottomSum = new int[H];
        upSum = new int[H];
        prefixSum = new int[H];

        for(int i = 0;i<N/2;i++){
            int b = sc.nextInt()-1;
            int u = sc.nextInt()-1;
            bottomSum[b]++;
            upSum[H-1-u]++;
        }

        for(int i =0;i<H-1;i++){
            upSum[i+1] += upSum[i];
            bottomSum[H-(i+2)] += bottomSum[H-(i+1)];
        }

        for(int i =0;i<H;i++){
            prefixSum[i] = upSum[i]+bottomSum[i];
        }
        Arrays.sort(prefixSum);


        int cnt = 0;
        for(int i = 0;i<H;i++){
            if(prefixSum[0]==prefixSum[i]) cnt++;
            else break;
        }
        System.out.println(prefixSum[0]+" "+cnt);
    }
}