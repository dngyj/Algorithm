import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static  Scanner sc = new Scanner(System.in);
    static int N,M;
    static ArrayList<Integer>[] list;
    static int[] indegree;
    static String ans;

    public static void main(String[] args) {
       input();
       topological();
        System.out.println(ans);

    }
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        indegree = new int[N+1];
        list = new ArrayList[N+1];
        for(int i =0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0;i<M;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            list[st].add(ed);
            indegree[ed]++;
        }
    }
    static void topological(){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1;i<N+1;i++){
            if(indegree[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur+" ");

            for(int next : list[cur]){
                indegree[next]--;
                if(indegree[next]==0) queue.add(next);
            }
        }
        ans = sb.toString();
    }
}