import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, Length, maxWeight;
    static int[] trucks;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        input();
        getMinTime();
    }
    
    static void getMinTime(){
        Queue<Integer> queue = new ArrayDeque<>();
        int time = 1;
        int idx = 0;
        int totalWeight = 0;
        queue.add(trucks[idx]);
        totalWeight += trucks[idx];
        time++;
        int cnt = 0;
        
        while(true){
            if(queue.size()>=Length) {
                int out = queue.poll();
                totalWeight-=out;
                if(out != 0) cnt++;
                if(cnt == N) break;
            }
            if(idx+1<N&&trucks[idx+1]+totalWeight<=maxWeight){
                idx++;
                queue.add(trucks[idx]);
                totalWeight+=trucks[idx];
            }
            else queue.add(0);
            time++;
        }
        System.out.println(time);
    }
    
    static void input(){
        N = sc.nextInt();
        Length = sc.nextInt();
        maxWeight = sc.nextInt();
        trucks = new int[N];
        for(int i = 0 ;i<N;i++){
            trucks[i] = sc.nextInt();
        }
    }
}