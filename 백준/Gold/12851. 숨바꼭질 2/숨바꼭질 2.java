import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,K;
    static int cnt;
    static int[] time;
    static int min = Integer.MAX_VALUE;
    static Queue<Integer> queue= new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        time = new int[100001];
        cnt = 0;

        if (N >= K) {
            System.out.println((N-K) + "\n1");
            return;
        }
        queue.add(N);

        bfs();
        System.out.println(min-1);
        System.out.println(cnt);

    }
    public static void bfs(){
        time[N] = 1;
        while(!queue.isEmpty()){

            int loc =  queue.poll();

//            System.out.println("loc :"+loc+" cnt :"+cnt );

            if(min<time[loc]) continue;


            if(loc == K) {
                min = time[loc];
//                System.out.println("min :"+ min);
                cnt++;
                continue;
            }
            if(0<=loc-1&&(time[loc-1]==0||time[loc-1]==time[loc]+1)){
                queue.add(loc - 1);
                time[loc-1] = time[loc]+1;
            }

            if(loc+1<=100000&&(time[loc+1]==0||time[loc+1]==time[loc]+1)){
                queue.add(loc+1);
                time[loc+1] = time[loc]+1;
            }

            if(2*loc<=100000&&(time[2*loc]==0||time[2*loc]==time[loc]+1)){
                queue.add(2*loc);
                time[2*loc] = time[loc]+1;
            }
        }


    }

}