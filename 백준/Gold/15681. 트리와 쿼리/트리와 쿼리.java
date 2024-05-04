import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,R,Q;
    static ArrayList<Integer>[] list;
    static int[] subtrees;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        Q = sc.nextInt();

        list = new ArrayList[N+1];
        for(int i = 1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        subtrees = new int[N+1];
        Arrays.fill(subtrees,1);

        for(int i = 0; i<N-1;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            list[st].add(ed);
            list[ed].add(st);
        }

        dfs(R,-1);

        for(int i = 0;i<Q;i++){
            int query = sc.nextInt();
            System.out.println(subtrees[query]);
        }
    }
    
    static void dfs(int now, int parent){

        for(int next:list[now]){
            if(parent!=next){
                dfs(next, now);
            }
        }
        if(parent!=-1) subtrees[parent]+=subtrees[now];
    }
}