import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] str = sc.next().toCharArray();
        Arrays.sort(str);

        for(int i=str.length-1;i>=0;i--){
            System.out.print(str[i]);
        }
    }

}