import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static String st;
    static String ed;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        st = sc.next();
        ed = sc.next();

        recur(ed);

        if(flag) System.out.println(1);
        else System.out.println(0);

    }
    static void recur(String s){
        if(s.equals(st)){
            flag = true;
            return;
        }
        if(s.length()<st.length()){
            return;
        }
        else{
            char[] ch = s.toCharArray();
            if(ch[0]=='B'){
                StringBuilder sb = new StringBuilder();
                for(int i = ch.length-1; i>=1;i--){
                    sb.append(ch[i]);
                }
                recur(sb.toString());
            }
            if(ch[ch.length-1]=='A'){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i<ch.length-1;i++){
                    sb.append(ch[i]);
                }
                recur(sb.toString());
            }
        }
    }
}