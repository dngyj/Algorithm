import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N,M;
    static int[] parents;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<Node> edgeList = new ArrayList<>();
    static double ans = 0;

    static class Node implements Comparable<Node>{
        int st;
        int ed;
        double w;

        Node(int st, int ed, double w){
            this.st=st;
            this.ed=ed;
            this.w=w;
        }

        @Override
        public int compareTo(Node o){
            return Double.compare(w, o.w);
        }
    }

    public static void main(String[] args) {
        input();
        connect();
        kruskal();
        System.out.printf("%.2f", ans);
    }

    static void kruskal(){
        for(int i = 0; i<edgeList.size();i++){
            int st = edgeList.get(i).st;
            int ed = edgeList.get(i).ed;
            double w = edgeList.get(i).w;
            if(!isParent(st,ed)){
                union(st,ed);
                ans += w;
            }
        }
    }

    static void connect(){
        for(int i =0; i<N-1;i++){
            for(int j = i+1;j<N;j++){
                int[] o1 = list.get(i);
                int[] o2 = list.get(j);
                edgeList.add(new Node(i,j,getDistance(o1,o2)));
            }
        }
        Collections.sort(edgeList);
    }

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        parents = new int[N+1];
        for(int i = 0; i<N+1;i++) parents[i] = i;

        for(int i =0; i<N;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new int[]{x,y});
        }
        for(int i = 0; i<M;i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            union(a,b);
        }
    }

    static int findset(int a){
        if(parents[a]!=a) return parents[a]=findset(parents[a]);
        return a;
    }
    static void union(int a, int b){
        a = findset(a);
        b = findset(b);
        if(a!=b){
            parents[b] = a;
        }
    }
    static boolean isParent(int a, int b){
        if(findset(a)!= findset(b)) return false;
        return true;
    }
    static double getDistance(int[] o1, int[] o2){
        int r1 = o1[0];
        int c1 = o1[1];
        int r2 = o2[0];
        int c2 = o2[1];
        return Math.sqrt(Math.pow(r1-r2,2)+Math.pow(c1-c2,2));
    }
}