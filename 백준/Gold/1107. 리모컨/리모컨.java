import java.util.Scanner;

public class Main {

    static int target;
    static int M;
    static boolean[] broken;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        target = sc.nextInt();
        M = sc.nextInt();

        broken = new boolean[10];
        for(int i = 0;i<M;i++){
            int n = sc.nextInt();
            broken[n] = true;
        }

        int ans = Math.abs(target-100);

        for(int i =0;i<999999;i++){
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBroken = false;
            for(int j=0;j<len;j++) {
                if (broken[str.charAt(j)-'0']){
                    isBroken = true;
                    break;
                }
            }
            if(!isBroken){
                int min = Math.abs(target-i)+len;
                ans = Math.min(min, ans);
            }
        }
        System.out.println(ans);
    }
}