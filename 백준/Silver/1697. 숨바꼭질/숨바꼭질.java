import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int from, to;
    static int[] map = new int[100001];
    static boolean[] visited = new boolean[100001];

    static Queue<Integer> queue = new LinkedList();

    public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);

         from = sc.nextInt();
         to = sc.nextInt();

         queue.add(from);
         bfs();

    }

    private static void bfs() {

        while(!queue.isEmpty()){
            int loc = queue.poll();

            if(loc == to){
                System.out.println(map[loc]);
                return;
            }

            if(0<=loc-1&&!visited[loc-1]) {
                map[loc - 1] = map[loc] + 1;
                visited[loc - 1] = true;
                queue.add(loc - 1);
            }
            if(loc+1<=100000&&!visited[loc+1]){
                map[loc+1] = map[loc]+1;
                visited[loc + 1] = true;
                queue.add(loc+1);
            }
           if(2*loc<=100000&&!visited[2*loc]){
               map[2*loc] = map[loc]+1;
               visited[2*loc] = true;
               queue.add(2*loc);
           }


        }
    }
}