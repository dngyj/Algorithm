import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];

        for(int i = 0; i<N;i++){
           arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        selected = new int[M];
        visited = new boolean[N];
        perm(0,0);
        System.out.println(sb);
    }
    public static void perm(int depth, int idx){
        if(depth == M){
            for(int i = 0; i<M;i++){
                sb.append(selected[i]+" ");
            }
            sb.append("\n");
            return;
        }
        int check = 0;
        for(int i = 0; i<N;i++){
            if(visited[i]) continue;
            if(check==arr[i]) continue;
            visited[i] = true;
            selected[idx] = arr[i];
            check = selected[idx];
            perm(depth+1, idx+1);
            visited[i] = false;
        }
    }
}