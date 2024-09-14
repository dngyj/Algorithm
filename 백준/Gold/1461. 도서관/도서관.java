import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] loc;
    static int N, M, steps;
    static int center = -1;

    public static void main(String[] args) {
        input();
        Arrays.sort(loc);
        findCenterIndex();
        fillBook();
        System.out.println(steps);
    }

    static void fillBook(){
        steps = 0;
        int left = 0;
        int right = N;

        while(left<center){
            if(left==0&&Math.abs(loc[0])>=Math.abs(loc[N])){
                steps+=Math.abs(loc[left]);
            }
            else steps+=2*Math.abs(loc[left]);
            left+=M;
        }

        while(right>center){
            if(right==N&&Math.abs(loc[0])<Math.abs(loc[N])){
                steps+=Math.abs(loc[right]);
            }
            else steps+=2*Math.abs(loc[right]);
            right-=M;
        }
    }

    static void findCenterIndex(){
        for(int i = 0; i<=N; i++){
            if(loc[i]==0) center = i;
        }
    }

    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        loc = new int[N+1];
        for(int i = 0; i<N; i++){
            loc[i] = sc.nextInt();
        }
        loc[N] = 0;
    }
}