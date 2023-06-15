import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        BigInteger facto = BigInteger.ONE;

        for (int num = N; num > 1; num--) {
            facto = facto.multiply(BigInteger.valueOf(num));
        }

        int cnt = 0;

        while (facto.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            cnt++;
            facto = facto.divide(BigInteger.TEN);
        }
        System.out.println(cnt);
    }
}