import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[M];
        for(int i = 0;i<N;i++){
            A[i] = sc.nextInt();
        }
        for(int i = 0;i<M;i++){
            B[i] = sc.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B);

        int pointA = 0;
        int pointB = 0;

        StringBuilder sb = new StringBuilder();

        while(pointA<N&&pointB<M){
            if(A[pointA]<=B[pointB]){
                sb.append(A[pointA]+" ");
                pointA++;
            }
            else if(A[pointA]>B[pointB]){
                sb.append(B[pointB]+" ");
                pointB++;
            }
        }
        if(pointA==N){
            while(pointB<M){
                sb.append(B[pointB++]+" ");
            }
        }
        if(pointB==M){
            while(pointA<N){
                sb.append(A[pointA++]+" ");
            }
        }

        System.out.println(sb);
    }
}