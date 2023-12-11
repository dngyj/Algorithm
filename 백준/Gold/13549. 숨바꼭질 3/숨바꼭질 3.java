import java.util.*;

public class Main {

    static int N, K;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    static Queue<Node> queue = new LinkedList<>();

    public static class Node{
        int v;
        int w;

        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        if (N >= K) {
            System.out.println((N-K));
            return;
        }

        queue.add(new Node(N,0));
        visited = new boolean[100001];

        bfs();
        System.out.println(min);
    }

    public static void bfs(){

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int loc = node.v;
            int weight = node.w;

            visited[loc] = true;

            if(loc==K){
                min = Math.min(min, weight);

            }
            int next1 = 2*loc;
            int next2 = loc-1;
            int next3 = loc+1;

            if(canGo(next1)){
                queue.add(new Node(next1,weight));
            }
            if(canGo(next2)){
                queue.add(new Node(next2,weight+1));
            }
            if(canGo(next3)){
                queue.add(new Node(next3, weight+1));
            }


        }
    }

    public static boolean canGo(int next){
        if(next<0||next>100000||visited[next]) return false;
        else return visited[next]=true;
    }

}