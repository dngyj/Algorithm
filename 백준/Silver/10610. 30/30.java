import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int[] digits = new int[N.length()];
        int sum = 0;
        for(int i = 0;i<N.length();i++){
            digits[i] = N.charAt(i) - 48;
            sum+=digits[i];
        }
        Arrays.sort(digits);

        if(sum%3 == 0 && digits[0] == 0){
            for(int i = N.length()-1; i>=0;i--){
                System.out.print(digits[i]);
            }
        }
        else System.out.println(-1);
    }
}