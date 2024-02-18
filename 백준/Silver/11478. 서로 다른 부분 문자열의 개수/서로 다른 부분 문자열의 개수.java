import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();

        String str = sc.next();
        for(int l =0;l<str.length();l++){
            StringBuilder sb = new StringBuilder();
            for(int i=l;i<str.length();i++){
                sb.append(str.charAt(i));
                set.add(sb.toString());
            }
        }
        System.out.println(set.size());
    }
}