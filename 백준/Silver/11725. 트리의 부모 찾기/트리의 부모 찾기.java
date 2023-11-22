import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] parents;
    static boolean[] visited;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        parents = new int[N+1];
        visited = new boolean[N+1];
        arr = new ArrayList[N+1];

        for(int i = 0; i<N+1;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0 ; i<N-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }
        dfs(1);

        for(int i=2; i<parents.length; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int index) {
        visited[index] = true;
        for(int v: arr[index]){
            if(!visited[v]) {
                parents[v] = index;
                dfs(v);
            }
        }

    }

}