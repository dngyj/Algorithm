import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,M;
    static ArrayList<Integer>[] list;
    static boolean[] gomgom;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        list = new ArrayList[N+1];
        gomgom = new boolean[N+1];
        for(int i=0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0;i<M;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            list[st].add(ed);
        }
        int S = sc.nextInt();
        for(int i =0;i<S;i++){
            int num = sc.nextInt();
            gomgom[num] = true;
        }
        System.out.println(bfs());
    }
    static String bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(gomgom[now]) continue;
            if(list[now].isEmpty()) return "yes";
            for(int next : list[now]){
                queue.add(next);
            }
        }
        return "Yes";
    }
}