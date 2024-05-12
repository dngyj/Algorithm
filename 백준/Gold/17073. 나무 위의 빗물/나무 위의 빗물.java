import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N,W;
    static ArrayList<Integer>[] list;
    static double avg;
    static int leafCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = sc.nextInt();
        list = new ArrayList[N+1];
        for(int i = 0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i<N-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        calculateAvg();
        System.out.println(String.format("%.10f", (double)W/leafCount));
    }

    static void calculateAvg(){
        for(int i = 2;i<N+1; i++){
            if(list[i].size()==1) leafCount ++;
        }
    }
}