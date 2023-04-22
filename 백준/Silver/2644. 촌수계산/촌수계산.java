import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer>[] adjList;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();// 전체 사람 수
        visited = new boolean[N+1];
        adjList = new ArrayList[N+1];

        for(int i=1; i<N+1;i++){
            adjList[i] = new ArrayList<>();
        }

        int targetA = sc.nextInt();
        int targetB = sc.nextInt();

        int M = sc.nextInt(); // 관계의 개수

        for(int i = 0; i<M;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();

            adjList[st].add(ed);
            adjList[ed].add(st);
        }
        find(targetA, targetB, 0);
        if(result ==0) System.out.println(-1);
        else System.out.println(result);
    }

    private static void find(int st, int ed, int cnt) {
        if(st==ed){
            result = cnt;
            return;
        }

        visited[st] = true;
        for(int i=0; i<adjList[st].size();i++){
            int newSt = adjList[st].get(i);
            if(!visited[newSt]){
                find(newSt, ed, cnt+1);
            }
        }
    }
}