import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<Node>[] g;
    static class Node{
        int x, w, max;
        public Node(int x, int w) {
            super();
            this.x = x;
            this.w = w;
        }
        public Node(int x, int w, int max) {
            super();
            this.x = x;
            this.w = w;
            this.max = max;
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken())-1;
        int b = Integer.parseInt(st.nextToken())-1;
        
        g = new ArrayList[n];

        for (int i=0;i<n;i++) {
            g[i] = new ArrayList<Node>();
        }

        for (int i=0;i<n-1;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            g[x].add(new Node(y, w));
            g[y].add(new Node(x, w));
        }

        bfs(a, b);
    }

    public static void bfs(int a, int b) {
        Queue<Node> q = new LinkedList<Node>();
        boolean[] visited = new boolean[n];
        visited[a] = true;
        q.add(new Node(a, 0, 0));

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.x == b) {
                System.out.println(now.w-now.max);
                break;
            }
            for(Node next : g[now.x]) {
                if(!visited[next.x]) {
                    visited[next.x] = true;
                    q.add(new Node(next.x, now.w+next.w, Math.max(now.max, next.w)));
                }
            }
        }
    }
}