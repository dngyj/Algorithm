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
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,0});
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int now = info[0];
            boolean flag = false;
            if(gomgom[now]) {
                flag = true;
                continue;
            }
            if(list[now].isEmpty()&&info[1]==0) return "yes";
            for(int next : list[now]){
                if(flag) queue.add(new int[]{next,1});
                else queue.add(new int[]{next,0});
            }
        }
        return "Yes";
    }
}