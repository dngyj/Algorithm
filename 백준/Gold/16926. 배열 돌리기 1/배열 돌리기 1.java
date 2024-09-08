import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int R = sc.nextInt();
        arr = new int[N][M];

        for(int r = 0; r<N;r++){
            for(int c = 0; c<M;c++){
                arr[r][c] = sc.nextInt();
            }
        }

        int depth = Math.min(N,M)/2;
        rotate(R, depth);
        printResult();
    }

    static void rotate(int R, int depth){
        for(int r=0;r<R;r++) {
            for(int d = 0; d<depth;d++) {
                int temp = arr[d][d];
                for(int k=d+1; k<M-d; k++)
                    arr[d][k-1] = arr[d][k];

                for(int k=d+1; k<N-d; k++)
                    arr[k-1][M-1-d] = arr[k][M-1-d];

                for(int k=M-2-d; k>=d; k--)
                    arr[N-1-d][k+1] = arr[N-1-d][k];

                for(int k=N-2-d; k>=d; k--)
                    arr[k+1][d] = arr[k][d];

                arr[d+1][d] = temp;
            }
        }
    }

    static void printResult(){
        for(int r=0;r<N;r++){
            for(int c=0;c<M;c++){
                System.out.print(arr[r][c]+" ");
            }
            System.out.println();
        }
    }
}