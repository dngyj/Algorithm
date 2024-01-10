import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    static ArrayList<Node>[] list;
    static class Node{
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i =1;i<N+1;i++){
            list[i] = new ArrayList<Node>();
        }
        for(int i = 0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[parent].add(new Node(v,w));
            list[v].add(new Node(parent,w));
        }

        for(int i = 1;i<=N;i++){
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i,0);
        }
        System.out.println(max);
    }

    static void dfs(int nodeNum, int sum){
        for(Node node : list[nodeNum]){
            if(!visited[node.v]){
                visited[node.v] = true;
                dfs(node.v,node.w+sum);
            }
        }
        max = Math.max(max,sum);
    }

}