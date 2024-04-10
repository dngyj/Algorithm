import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[] parents;
    static double ans;
    static class Node implements Comparable<Node>{
        int st;
        int ed;
        double w;
        Node(int st, int ed, double w){
            this.st = st;
            this.ed = ed;
            this.w = w;
        }
        @Override
        public int compareTo(Node o){
            if(w<o.w) return -1;
            return 1;
        }
    }
    static class Point{
        double x;
        double y;
        Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Point> stars = new ArrayList<>();
    static ArrayList<Node> edgeList = new ArrayList<>();

    public static void main(String[] args) {
        input();
        connectStar();
        kruskal();
        System.out.println(ans);
    }
    static void input(){
        N = sc.nextInt();
        for(int i = 0;i<N;i++){
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            stars.add(new Point(x,y));
        }
    }
    static void connectStar(){
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                Point p1 = stars.get(i);
                Point p2 = stars.get(j);
                edgeList.add(new Node(i,j,getDistance(p1,p2)));
            }
        }
        Collections.sort(edgeList);
    }
    static double getDistance(Point p1, Point p2){
        return Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2));
    }
    static void kruskal(){
        initParents();
        for(int i = 0;i<edgeList.size();i++){
            int st = edgeList.get(i).st;
            int ed = edgeList.get(i).ed;
            if(!isParent(st,ed)){
                union(st,ed);
                ans += edgeList.get(i).w;
            }
        }

    }
    static void initParents(){
        parents = new int[N+1];
        for(int i =0;i<N+1;i++) parents[i] = i;
    }

    static void union(int x, int y){
        x = findSet(x);
        y = findSet(y);
        if(x!=y) parents[y] = x;
    }
    static int findSet(int x){
        if(x==parents[x]) return x;
        else return parents[x] = findSet(parents[x]);
    }

    static boolean isParent(int x, int y){
        if(findSet(x)==findSet(y)) return true;
        else return false;
    }
}