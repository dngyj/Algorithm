import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        char[] word = sc.next().toCharArray();
        int[] alpha = new int[26];

        for(int i =0;i<word.length;i++){
            alpha[word[i]-65]++;
        }
        int cnt = 0;
        for(int i =0;i<26;i++){
            if(alpha[i]%2==1) cnt++;
        }
        String ans ="";

        if(cnt>=2) {
            ans+="I'm Sorry Hansoo";
        }
        else{
            StringBuilder sb = new StringBuilder();
            for(int i =0;i<26;i++){
                for(int r=0; r<alpha[i]/2; r++) {
                    sb.append((char)(i+65));
                }
            }
            ans+=sb.toString();
            String end = sb.reverse().toString();
            sb = new StringBuilder();
            for(int i=0; i<alpha.length; i++) {
                if(alpha[i]%2==1) {
                    sb.append((char)(i+65));
                }
            }
            ans +=sb.toString()+end;

        }
        System.out.println(ans);
    }
}