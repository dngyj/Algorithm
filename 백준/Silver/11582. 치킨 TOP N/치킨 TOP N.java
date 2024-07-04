import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i<N;i++) arr[i] = sc.nextInt();
        int K = sc.nextInt();

        sort(N/2, arr, K);
    }
    
    static void sort(int member, int[] arr, int K){
        int part = N/member;
        int[] cur = new int[N];

        for(int idx = 0; idx<=N-part;idx+=part){
            Arrays.sort(arr,idx,idx+part);
            for(int i = idx; i<idx+part;i++){
                cur[i] = arr[i];
            }
        }
        if(member==K){
            for(int i = 0; i<N;i++) System.out.print(arr[i]+" ");
            return;
        }
        sort(member/2, cur, K);
    }
}