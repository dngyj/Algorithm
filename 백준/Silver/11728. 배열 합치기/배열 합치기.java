import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] AB = new int[N+M];
        for(int i = 0;i<N;i++){
            AB[i] = sc.nextInt();
        }
        for(int i = N;i<N+M;i++){
            AB[i] = sc.nextInt();
        }
        Arrays.sort(AB);
        StringBuilder sb = new StringBuilder();
        for(int i : AB){
            sb.append(i+" ");
        }
        System.out.println(sb);
    }
}