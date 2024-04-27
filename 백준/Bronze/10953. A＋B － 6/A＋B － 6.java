import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i =0;i<N;i++){
            String str = sc.next();
            int A = str.charAt(0)-'0';
            int B = str.charAt(2)-'0';
            System.out.println(A+B);
        }
    }
}