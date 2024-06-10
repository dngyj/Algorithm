import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int firstDiff = sc.nextInt();
        int lastDiff = N;

        int maxDiff = 0;
        int tmp = firstDiff;
        for(int i = 1;i<M;i++){
            int x = sc.nextInt();
            maxDiff = Math.max(maxDiff,x-tmp);
            tmp = x;
            lastDiff = N-x;
        }
        int diff = 0;
        if(maxDiff%2==1) diff = maxDiff/2+1;
        else diff = maxDiff/2;
        
        int ans = Math.max(firstDiff,Math.max(lastDiff,diff));
        System.out.println(ans);
    }
}