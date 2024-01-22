import java.util.Scanner;

public class Main {

    static int N;
    static long B;
    static long[][] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        B = sc.nextLong();

        A = new long[N][N];
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                A[r][c] = sc.nextInt()%1000;
            }
        }

        long[][] ans = matrixPow(A, B);
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                System.out.print(ans[r][c]+" ");
            }
            System.out.println();
        }

    }
    static long[][] matrixPow(long[][] A, long exp){
        if(exp==1L) return A;
        else{
            long[][] temp = matrixPow(A, exp/2);
            if(exp%2==0) return multiply(temp, temp);
            else return multiply(multiply(temp, temp), A);
        }
    }

    static long[][] multiply(long[][] o1, long[][] o2){

        long[][] temp = new long[N][N];
        for(int k = 0; k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    temp[i][j] += o1[i][k]*o2[k][j];
                    temp[i][j] %= 1000;
                }
            }
        }
        return temp;
    }
}