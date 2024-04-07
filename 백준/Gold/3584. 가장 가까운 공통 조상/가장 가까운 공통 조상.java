import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int A, B;
    static int ans;
    static int[] parents;
    static boolean[] checked;

    public static void main(String[] args) {
        int T = sc.nextInt();
        for(int tc=0;tc<T;tc++){
           input();
           findLCA();
           System.out.println(ans);
        }
    }

    static void input(){
        N = sc.nextInt();
        parents = new int[N+1];
        checked = new boolean[N+1];
        for(int i =0; i<N-1;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            parents[ed] = st;
        }
        A = sc.nextInt();
        B = sc.nextInt();
    }

    static void findLCA(){
        int temp = A;
        while(temp != 0){
            checked[temp] = true;
            temp = parents[temp];
        }
        int temp2 = B;
        while(temp2 != 0){
            if(checked[temp2]) {
                ans = temp2;
                return;
            }
            temp2 = parents[temp2];
        }
    }
}