import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] scores;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        scores = new int[N+1];
        list = new ArrayList[N+1];
        for(int i = 0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=1;i<N+1;i++){
            int sangsa = sc.nextInt();
            if(sangsa==-1) sangsa = 0;
            list[sangsa].add(i);
        }

        for(int i = 0;i<M;i++){
            int num = sc.nextInt();
            int w = sc.nextInt();
            scores[num] +=w;
        }
        dfs(1);

        for(int i = 1;i<N+1;i++){
            System.out.print(scores[i]+" ");
        }
    }

    static void dfs(int now){
        for(int next:list[now]){
            scores[next] += scores[now];
            dfs(next);
        }
    }
}