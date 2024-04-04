import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int T,N,K,W;
    static int[] indegree;
    static int[] time;
    static int[] dp;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) {
        T = sc.nextInt();
        for(int tc=0;tc<T;tc++){
            input();
            topological();
            System.out.println(dp[W]);
        }
    }

    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();
        indegree = new int[N+1];
        time = new int[N+1];
        dp = new int[N+1];
        for(int i =1;i<N+1;i++){
            time[i] = sc.nextInt();
        }
        list = new ArrayList[N+1];
        for(int i =1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0;i<K;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            list[st].add(ed);
            indegree[ed]++;
        }
        W = sc.nextInt();
    }

    static void topological(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1;i<N+1;i++){
            if(indegree[i]==0) {
                dp[i] = time[i];
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next:list[cur]){
                indegree[next]--;
                dp[next] = Math.max(dp[cur]+time[next],dp[next]);
                if(indegree[next]==0){
                    queue.add(next);
                }
            }
        }
    }
}