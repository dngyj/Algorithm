import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, R1,R2;
    static ArrayList<Node>[] list;
    static class Node{
        int ed;
        int w;
        Node(int ed, int w){
            this.ed = ed;
            this.w=w;
        }
    }
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R1= sc.nextInt();
        R2 = sc.nextInt();
        list = new ArrayList[N+1];
        for(int i=0; i<N+1;i++){
            list[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int w = sc.nextInt();
            list[st].add(new Node(ed,w));
            list[ed].add(new Node(st,w));
        }
        bfs();
    }

    static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{R1,0,0});
        visited = new boolean[N+1];
        visited[R1] = true;
        int answer = 0;

        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int cur = info[0];
            int w = info[1];
            int max = info[2];

            if(cur==R2) answer = w - max;

            for(Node node:list[cur]){
                int next = node.ed;
                int w1 = node.w;
                max = Math.max(w1,max);
                if(visited[next]) continue;
                visited[next] = true;
                queue.add(new int[]{next, w+w1,max});
            }
        }
        System.out.println(answer);
    }
}