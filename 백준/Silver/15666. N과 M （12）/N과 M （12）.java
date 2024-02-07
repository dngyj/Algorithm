import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] arr;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        selected = new int[M];

        comb(0,0);
        System.out.println(sb);

    }
    static void comb(int idx, int depth){
        if(depth == M){
            for(int i=0;i<M;i++) {
                sb.append(selected[i]+" ");
            }
            sb.append("\n");
        }
        else{
            int check = -1;
            for(int i = idx; i<N;i++){
                if(check == arr[i]) continue;
                check = arr[i];
                selected[depth] = arr[i];
                comb(i, depth+1);
            }
        }
    }
}