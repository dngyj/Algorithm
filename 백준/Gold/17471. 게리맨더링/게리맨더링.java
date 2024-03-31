import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] weights;
    static boolean[] selected;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static Scanner sc = new Scanner(System.in);
    static int ans = Integer.MAX_VALUE;

    static void input(){
        N = sc.nextInt();
        weights= new int[N+1];
        selected = new boolean[N+1];
        for(int i = 1;i<N+1;i++){
            weights[i] = sc.nextInt();
        }
        list = new ArrayList[N+1];
        for(int i =0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i =1;i<N+1;i++){
            int K = sc.nextInt();
            for(int k=0;k<K;k++){
                int num = sc.nextInt();
                list[i].add(num);
            }
        }
    }

    public static void main(String[] args) {
        input();
        //1. 부분집합
        devide(1);

        if(ans==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    static void devide(int idx){
        if(idx==N+1){
            ArrayList<Integer> area1 = new ArrayList<>();
            ArrayList<Integer> area2 = new ArrayList<>();

            for(int i = 1; i<N+1;i++){
                if(selected[i]) area1.add(i);
                else area2.add(i);
            }
            if(area1.isEmpty()||area2.isEmpty()) return;

            if(check(area1)&&check(area2)){//2. 연결된건지 체크
                getMinDiff(); //3. 인구수 계산
            }
            return;
        }
        devide(idx+1);
        selected[idx] = true;
        devide(idx+1);
        selected[idx] = false;

    }

    static boolean check(ArrayList<Integer> area){
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N+1];
        visited[area.get(0)] = true;
        queue.add(area.get(0));

        int cnt = 1;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : list[cur]){
                if(area.contains(next)&&!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    cnt++;
                }
            }
        }
        if(cnt==area.size()) return true;
        else return false;
    }

    static void getMinDiff(){
        int cntA = 0, cntB=0;
        for(int i=1;i<N+1;i++){
            if(selected[i]) cntA += weights[i];
            else cntB += weights[i];
        }
        int diff = Math.abs(cntA-cntB);
        ans = Math.min(diff,ans);
    }
}