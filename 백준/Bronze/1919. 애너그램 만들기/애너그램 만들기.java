import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] str = sc.next().toCharArray();
        char[] str2 = sc.next().toCharArray();

        int[] alpha = new int[26];
        for(int i = 0 ;i<str.length;i++){
            alpha[str[i]-'a']++;
        }
        for(int i = 0 ;i<str2.length;i++){
            alpha[str2[i]-'a']--;
        }
        int cnt = 0;
        for(int i =0;i<alpha.length;i++){
            if(alpha[i]!=0) cnt+= Math.abs(alpha[i]);
        }
        System.out.println(cnt);
    }
}