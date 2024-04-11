import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static class Point{
        int idx;
        int x;
        int y;
        int z;
        Point(int idx, int x, int y, int z){
            this.idx = idx;
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }
    static class Node implements Comparable<Node>{
        int st;
        int ed;
        int w;
        Node(int st, int ed, int w){
            this.st=st;
            this.ed=ed;
            this.w=w;
        }
        @Override
        public int compareTo(Node o){
            return w-o.w;
        }
    }
    static Point[] points;
    static ArrayList<Node> lists = new ArrayList<>();
    static int[] parents;
    static long ans;

    public static void main(String[] args) {
        input();
        connectPlanet();
        kruskal();
        System.out.println(ans);
    }

    static void input(){
        N = sc.nextInt();
        points = new Point[N];
        for(int i = 0;i<N;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            points[i] = new Point(i,x,y,z);
        }
    }

    static void connectPlanet(){
        Arrays.sort(points, Comparator.comparingInt(p -> p.x));
        for(int i = 0;i<N-1;i++){
            int w = Math.abs(points[i].x-points[i+1].x);
            lists.add(new Node(points[i].idx, points[i+1].idx, w));
        }
        Arrays.sort(points, Comparator.comparingInt(p -> p.y));
        for(int i = 0;i<N-1;i++){
            int w = Math.abs(points[i].y-points[i+1].y);
            lists.add(new Node(points[i].idx, points[i+1].idx, w));
        }
        Arrays.sort(points, Comparator.comparingInt(p -> p.z));
        for(int i = 0;i<N-1;i++){
            int w = Math.abs(points[i].z-points[i+1].z);
            lists.add(new Node(points[i].idx, points[i+1].idx, w));
        }
    }

    static void kruskal(){
        parents = new int[N];
        for(int i = 0;i<N;i++) parents[i] = i;

        Collections.sort(lists);

        for(Node node : lists){
            if(!isParent(node.st,node.ed)){
                union(node.st, node.ed);
                ans += node.w;
            }
        }
    }

    static int findSet(int x){
        if(x==parents[x]) return x;
        else return parents[x] = findSet(parents[x]);
    }
    static void union(int a, int b){
        a = findSet(a);
        b = findSet(b);
        if(a!=b) parents[b] = a;
    }
    static boolean isParent(int a, int b){
        if(findSet(a)!=findSet(b)) return false;
        else return true;
    }
}