import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for(int i =1;i<str.length();i++){
            if(str.charAt(i)=='-') sb.append(str.charAt(i+1));
        }
        System.out.println(sb);
    }
}