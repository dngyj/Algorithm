import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int V;
    static int max = Integer.MIN_VALUE;
    static int end;
    static boolean[] visited;
    static class Node{
        int v;
        int w;
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    static ArrayList<Node>[] list;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        list = new ArrayList[V+1];
        for(int i =0; i<V+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i<V;i++){
            int st = sc.nextInt();
            while (true){
                int ed = sc.nextInt();
                if(ed==-1){
                     break;
                }
                int w = sc.nextInt();
                list[st].add(new Node(ed,w));
            }
        }
        end = 0;
        visited = new boolean[V+1];
        visited[1] = true;
        dfs(1,0);

        visited = new boolean[V+1];
        dfs(end,0);

        System.out.println(max);
    }

    static void dfs(int v, int sum){
        if(sum>max) {
            max = sum;
            end = v;
        }
        visited[v] = true;
        for(Node node : list[v]){
            if(!visited[node.v]) {
                visited[node.v] = true;
                dfs(node.v,node.w+sum);
            }
        }
    }
}