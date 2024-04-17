import java.util.Scanner;

public class Main {

    static int N;
    static int[] students;
    static boolean[] visited;
    static boolean[] checked;
    static int cnt;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=0;tc<T;tc++){
            N = sc.nextInt();
            students = new int[N+1];
            visited = new boolean[N+1];
            checked = new boolean[N+1];
            cnt = 0;
            for(int i = 1;i<N+1;i++){
                students[i] = sc.nextInt();
            }

            for(int i = 1;i<N+1;i++){
                if(checked[i]) continue;
                dfs(i);
            }
            System.out.println(N-cnt);
        }
    }
    static void dfs(int now){
        if(checked[now]) return;
        if(visited[now]){
            checked[now] = true;
            cnt++;
        }
        visited[now] = true;
        int next = students[now];
        dfs(next);
        visited[now] = false;
        
        checked[now] = true;
    }
}