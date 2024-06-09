import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] pillars = new int[1001];

        int maxIdx = -1;
        int max = -1;
        for(int i = 0; i<N;i++){
            int idx = sc.nextInt();
            int h = sc.nextInt();
            pillars[idx] = h;
            if(h>max){
                max = h;
                maxIdx = idx;
            }
        }
        int sum = 0;
        int maxLeft = -1;
        for(int i = 1;i<maxIdx;i++){
            if(pillars[i]>maxLeft){
                maxLeft = pillars[i];
            }
            sum+=maxLeft;
        }

        int maxRight = -1;
        for(int i = 1000;i>maxIdx;i--){
            if(pillars[i]>maxRight){
                maxRight = pillars[i];
            }
            sum+=maxRight;
        }
        sum+=max;

        System.out.println(sum);
    }

}