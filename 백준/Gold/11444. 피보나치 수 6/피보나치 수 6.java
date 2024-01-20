import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[][] A = {{1, 1},{1,0}};

        System.out.println(matrixPow(n-1, A)[0][0]);

    }
    static long[][] matrixPow(long exp, long[][] A){
        if(exp==1||exp==0) return A;

        long[][] temp = matrixPow(exp/2, A);
        temp = multiply(temp, temp);
        if(exp%2== 1L){
            temp = multiply(temp,new long[][]{{1,1},{1,0}});
        }
        
        return temp;
    }

    static long[][] multiply(long[][] o1, long[][] o2){
        long[][] temp = new long[2][2];

        for(int k=0;k<2;k++){
            for(int i=0;i<2;i++){
                for(int j=0; j<2; j++){
                    temp[i][j] += o1[i][k] * o2[k][j];
                    temp[i][j] %= 1000000007;
                }
            }
        }
        return temp;
    }
}