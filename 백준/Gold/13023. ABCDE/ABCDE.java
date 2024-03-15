import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N, M;
    static boolean[] visited;
    static boolean flag = false;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        list = new ArrayList[N];
        for(int i = 0;i<N;i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        for(int i=0;i<N;i++){
            visited = new boolean[N];
            dfs(i,1);
            if(flag) break;
        }
        if(flag) System.out.println(1);
        else System.out.println(0);
    }
    static void dfs(int now, int depth){
        if(depth==5) {
            flag = true;
            return;
        }
        visited[now] = true;
        for(int next:list[now]){
            if(visited[next]) continue;
            dfs(next, depth+1);
        }
        visited[now] = false;
    }
}