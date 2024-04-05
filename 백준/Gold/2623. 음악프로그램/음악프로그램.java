import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static int[] indegrees;
    static ArrayList<Integer>[] list;
    static StringBuilder sb = new StringBuilder();
    static String ans;

    public static void main(String[] args) {
        input();
        topological();
        if(check()) System.out.println(sb.toString());
        else System.out.println(0);
    }

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        indegrees = new int[N+1];
        list = new ArrayList[N+1];
        for(int i =0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0;i<M;i++){
            int K = sc.nextInt();
            int st = sc.nextInt();
            for(int k=1;k<K;k++){
                int ed = sc.nextInt();
                list[st].add(ed);
                indegrees[ed]++;
                st = ed;
            }
        }
    }

    static void topological(){
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1;i<N+1;i++){
            if(indegrees[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur).append("\n");
            for(int next:list[cur]){
                indegrees[next]--;
                if(indegrees[next]==0) queue.add(next);
            }
        }
    }

    static boolean check(){
        for(int i =1;i<N+1;i++){
            if(indegrees[i]!=0) return false;
        }
        return true;
    }
}