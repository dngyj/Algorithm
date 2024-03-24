import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[] gender;
    static int[] parents;
    static class Node implements Comparable<Node>{
        int st;
        int ed;
        int w;
        Node(int st, int ed, int w){
            this.st = st;
            this.ed = ed;
            this.w = w;
        }
        @Override
        public int compareTo(Node o){
            return w-o.w;
        }
    }
    static PriorityQueue<Node> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        gender = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            String isMW = sc.next();
            if (isMW.equals("M")) gender[i] = true;
        }
        parents = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int w = sc.nextInt();
            if(gender[st]!=gender[ed]) queue.add(new Node(st, ed, w));
        }
        int cnt = 1;
        int result = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int st = node.st;
            int ed = node.ed;
            int cost = node.w;
            if(!isParent(st,ed)){
                cnt++;
                union(st,ed);
                result+=cost;
            }
        }
        System.out.println(cnt==N?result:-1);
    }

    static int findSet(int x){
        if(x==parents[x]) return x;
        else return parents[x]=findSet(parents[x]);
    }
    static void union(int a, int b){
        a = findSet(a);
        b = findSet(b);
        parents[b] = a;
    }
    static boolean isParent(int a, int b){
        a = findSet(a);
        b = findSet(b);
        return a==b;
    }
}