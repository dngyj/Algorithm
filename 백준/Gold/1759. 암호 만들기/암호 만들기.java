import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int L,C;
    static String[] str;
    static boolean[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        str = new String[C];
        selected = new boolean[C];

        for(int i = 0;i<C;i++){
            str[i] = sc.next();
        }
        Arrays.sort(str);

        comb(0,0);
        System.out.println(sb);
    }
    static void comb(int idx, int depth){

        if(depth==L){
            StringBuilder sb2 = new StringBuilder();
            for(int i =0;i<C;i++) {
                if (selected[i]) {
                    sb2.append(str[i]);
                }
            }
            String temp = sb2.toString();
            int moem = 0;
            for(int i =0;i<L;i++) {
               if(temp.charAt(i)=='a'||temp.charAt(i)=='e'||temp.charAt(i)=='i'||temp.charAt(i)=='o'||temp.charAt(i)=='u') moem++;
            }
            int jaem = L-moem;
            if(moem>=1&&jaem>=2) {
                sb.append(sb2);
                sb.append("\n");
            }
        }
        for(int i =idx;i<C;i++){
            selected[i] = true;
            comb(i+1, depth+1);
            selected[i] = false;
        }
    }
}