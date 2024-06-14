import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.next().toCharArray();

        int cntA = 0;
        for(int i = 0; i<c.length;i++){
            if(c[i]=='a') cntA++;
        }
        int cntB = c.length-cntA;

        int range = cntA;
        char str = 'a';
        if(cntA>cntB){
            range = cntB;
            str = 'b';
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i<c.length;i++){
            int cnt = 0;
            for(int p=i; p<range+i; p++){
                if(c[p%c.length]!=str) cnt++;
            }
            min = Math.min(min,cnt);
        }
        System.out.println(min);
    }
}