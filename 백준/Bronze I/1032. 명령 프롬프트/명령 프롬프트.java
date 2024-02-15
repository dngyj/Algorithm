import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String temp = sc.next();
        for(int i = 1; i<N;i++){
            StringBuilder sb = new StringBuilder();
            String str = sc.next();
            for(int s = 0;s<str.length();s++){
                if(str.charAt(s)==temp.charAt(s)) sb.append(str.charAt(s));
                else sb.append("?");
            }
            temp = sb.toString();
        }
        System.out.println(temp);
    }

}