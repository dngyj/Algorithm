import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static boolean[] truth;
    static int[] parents;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        parents = new int[N+1];
        for(int i =1;i<N+1;i++){
            parents[i] = i;
        }
        int T = sc.nextInt();
        truth = new boolean[N+1];
        for(int i=0;i<T;i++){
            int num = sc.nextInt();
            truth[num] = true;
        }
        ArrayList<Integer>[] list = new ArrayList[M];
        for(int i =0;i<M;i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0;i<M;i++){
            int n = sc.nextInt();
            int a = 0;
            if(n>0){
                a = sc.nextInt();
                list[i].add(a);
            }
            for(int j=1;j<n;j++){
                int b = sc.nextInt();
                list[i].add(b);
                union(a,b);
            }
        }

        for(int i =1;i<truth.length;i++){
            if(truth[i]){
                truth[findset(i)] = true;
            }
        }

        int cnt = 0;
        for(int i=0;i<M;i++){
            if(!list[i].isEmpty()){
                int parent = findset(list[i].get(0));
                if(!truth[parent]) cnt++;
            }
        }
        System.out.println(cnt);
    }
    static void union(int a, int b){
        a = findset(a);
        b = findset(b);
        if(a!=b){
            if(a>b) parents[a] = b;
            else parents[b] = a;
        }
    }
    private static int findset(int x) {
        if(parents[x] == x)
            return parents[x] = x;
        else  return findset(parents[x]);

    }

}