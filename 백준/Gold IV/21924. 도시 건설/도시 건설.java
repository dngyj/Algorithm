import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int[] parents;
    static class Node implements Comparable<Node>{
        int st;
        int ed;
        int w;
        Node(int st, int ed, int w){
            this.st= st;
            this.ed= ed;
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
        parents = new int[N+1];
        for(int i = 1; i<N+1;i++){
            parents[i] = i;
        }
        long total =0;
        for(int i =0;i<M;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int w = sc.nextInt();
            total += w;
            queue.add(new Node(st,ed,w));
        }
        long min = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int st = node.st;
            int ed = node.ed;
            if(findset(st)!=findset(ed)){
                union(st,ed);
                min+=node.w;
            }
        }
        boolean flag = false;
        for(int i = 1; i<N;i++){
            if(findset(parents[i])!=findset(parents[i+1])) flag = true;
        }
        long ans;
        if(flag) ans = -1;
        else ans = total-min;
        System.out.println(ans);
    }

    static int findset(int x){
        if(x==parents[x]) return x;
        else return parents[x] = findset(parents[x]);
    }

    static void union(int a, int b){
        a = findset(a);
        b = findset(b);
        parents[b] = a;
    }
}