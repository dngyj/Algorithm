import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N,M,K;
    static int ans;
    static int[] parents;
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
    static ArrayList<Node> list = new ArrayList<>();

    public static void main(String[] args) {
        input();
        ans = 0;
        kruskal();
        System.out.println(ans);
    }
    
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        parents = new int[N];
        for(int i = 0;i<N;i++){
            parents[i] = i;
        }
        for(int i = 0;i<K;i++){
            int num = sc.nextInt()-1;
            parents[num] = -1;
        }
        for(int i =0;i<M;i++){
            int st = sc.nextInt()-1;
            int ed = sc.nextInt()-1;
            int w = sc.nextInt();
            list.add(new Node(st,ed,w));
        }
    }

    static void kruskal(){
        Collections.sort(list);

        for(Node node:list){
            if(!isParent(node.st,node.ed)){
                ans+=node.w;
                union(node.st,node.ed);
            }
        }
    }

    static int findset(int x){
        if(parents[x]==-1) return -1;
        if(x==parents[x]) return x;
        else return parents[x] = findset(parents[x]);
    }
    static void union(int a,int b){
        a = findset(a);
        b = findset(b);
        if(a==-1) parents[b] = a;
        else if(b==-1) parents[a] = b;
        else if(a!=b) parents[b] = a;
    }
    
    static boolean isParent(int a, int b){
        if(findset(a)!=findset(b)) return false;
        else return true;
    }
}