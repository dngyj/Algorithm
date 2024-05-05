import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M;
    static ArrayList<Node>[] list;
    static class Node{
        int ed;
        int w;
        Node(int ed, int w){
            this.ed = ed;
            this.w = w;
        }
    }
    static int dist;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for(int i = 0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0;i<N-1;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int w = sc.nextInt();
            list[st].add(new Node(ed,w));
            list[ed].add(new Node(st,w));
        }

        for(int i = 0;i<M;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            visited = new boolean[N+1];
            dist = 0;
            dfs(st,ed);
        }
    }

    static void dfs(int now, int ed){
        visited[now] = true;
        if(now == ed){
            System.out.println(dist);
            return;
        }
        else{
            for(int i = 0;i<list[now].size();i++){
                int next = list[now].get(i).ed;
                if(!visited[next]) {
                    visited[next] = true;
                    dist += list[now].get(i).w;
                    dfs(next,ed);
                    dist -= list[now].get(i).w;
                }
            }
        }
    }
}