import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();

        while(S.length()<T.length()){
            if(T.endsWith("A")) T =T.substring(0,T.length()-1);
            else{
                T = T.substring(0,T.length()-1);
                StringBuffer sb = new StringBuffer(T);
                T = sb.reverse().toString();
            }
        }

        if(S.equals(T)) System.out.println(1);
        else System.out.println(0);
    }

}