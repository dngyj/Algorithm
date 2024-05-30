import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int min = getMinNum(a,b,c,d);
        boolean[] isClockNum = checkClockNum();

        int cnt = 0;
        for(int i = 1111; i<=min;i++){
            if(isClockNum[i]) cnt++;
        }
        System.out.println(cnt);
    }
    static boolean[] checkClockNum() {
        boolean[] visit = new boolean[10000];

        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                for (int c = 1; c < 10; c++) {
                    for (int d = 1; d < 10; d++) {
                        int n = getMinNum(a, b, c, d);
                        if (!visit[n]) {
                            visit[n] = true;
                        }
                    }
                }
            }
        }
        return visit;
    }


    static int getMinNum(int a, int b, int c, int d){
        int min = Integer.MAX_VALUE;

        min = Math.min(min, a * 1000 + b * 100 + c * 10 + d);
        min = Math.min(min, b * 1000 + c * 100 + d * 10 + a);
        min = Math.min(min, c * 1000 + d * 100 + a * 10 + b);
        min = Math.min(min, d * 1000 + a * 100 + b * 10 + c);

        return min;
    }

}