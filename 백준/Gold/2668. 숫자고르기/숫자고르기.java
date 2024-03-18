import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N+1];

        for(int i = 1;i<N+1;i++){
            arr[i] = sc.nextInt();
        }

        ans = new ArrayList<>();
        visited = new boolean[N+1];
        for(int i = 1;i<N+1;i++){
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for(int i : ans){
            System.out.println(i);
        }

    }
    static void dfs(int st, int now){
        int next = arr[now];
        if(!visited[next]){
            visited[next] = true;
            dfs(st, next);
            visited[next] = false;
        }
        if(next==st) ans.add(st);
    }
}