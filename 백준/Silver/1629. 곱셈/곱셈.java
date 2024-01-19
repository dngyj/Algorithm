import java.util.Scanner;

public class Main {

    static long C;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        C = sc.nextLong();

        System.out.println(pow(A,B));
    }

    static long pow(long A, long n){
        if(n==1) return A%C;
        else{
            long temp = pow(A, n/2);
            if(n%2==0) return (temp*temp)%C;
            else return (temp*temp%C)*A%C;
        }
    }
}