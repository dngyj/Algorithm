import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> suffixs = new ArrayList<>();
        for(int i = 0;i<str.length();i++){
            String suffix = str.substring(i,str.length());
            suffixs.add(suffix);
        }
        Collections.sort(suffixs);
        for(String ans : suffixs){
            System.out.println(ans);
        }
    }
}