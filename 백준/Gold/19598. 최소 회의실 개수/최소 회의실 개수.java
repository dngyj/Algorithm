import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Meeting implements Comparable<Meeting>{
        int start_time;
        int end_time;

        public Meeting(int start_time, int end_time){
            this.start_time = start_time;
            this.end_time = end_time;
        }

        @Override
        public int compareTo(Meeting o){
            return start_time-o.start_time;
        }
    }
    static int N;
    static Meeting[] meetings;

    public static void main(String[] args) {
        input();
        Arrays.sort(meetings);
        calculateRoomCount();

    }
    
    static void calculateRoomCount(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(meetings[0].end_time);

        for(int i = 1; i<N; i++){
            if(pq.peek()<=meetings[i].start_time) pq.poll();
            pq.add(meetings[i].end_time);
        }
        System.out.println(pq.size());
    }

    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        meetings = new Meeting[N];
        for(int i = 0; i<N; i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            meetings[i] = new Meeting(st, ed);
        }
    }
}