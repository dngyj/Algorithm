import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] parents;
    static class Node implements Comparable<Node> {
        int st;
        int ed;
        int w;
        public Node(int st, int ed, int w) {
            this.st = st;
            this.ed = ed;
            this.w = w;
        }
        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }
    static PriorityQueue<Node> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        parents = new int[N+1];
        for(int i=1;i<N+1;i++){
            parents[i] = i;
        }
        for(int st=0;st<N;st++){
            for(int ed=0;ed<N;ed++){
                int cost = sc.nextInt();
                if(st!=ed){
                    queue.add(new Node(st+1,ed+1,cost));
                }
            }
        }
        long ans = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(findset(node.st)!=findset(node.ed)){
                union(node.st, node.ed);
                ans+=node.w;
            }
        }
        System.out.println(ans);
    }

    static int findset(int x){
        if(x==parents[x]) return x;
        else return parents[x]=findset(parents[x]);
    }

    static void union(int a, int b){
        a = findset(a);
        b = findset(b);
        if(a!=b) parents[b] = a;
    }

}