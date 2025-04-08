import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int[] counts = new int[10];

        int length = N.length();

        for(int i = 0; i<length; i++){
            int num = N.charAt(i)-'0';
            counts[num]++;
        }

        int sixNine = counts[6]+counts[9];
        counts[6] = counts[9] = (int)Math.ceil(sixNine/2.0);

        int max = -1;
        for(int i = 0; i<10; i++){
            max = Math.max(max, counts[i]);
        }
        System.out.println(max);
    }
}