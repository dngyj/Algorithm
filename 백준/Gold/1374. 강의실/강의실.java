import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int N;
    static class Lecture implements Comparable<Lecture>{
        int st;
        int ed;
        public Lecture(int st, int ed){
            this.st = st;
            this.ed = ed;
        }
        @Override
        public int compareTo(Lecture o){
            return st-o.st;
        }
    }
    
    static Lecture[] lectures;

    public static void main(String[] args) {
        input();
        Arrays.sort(lectures);
        caculate_min_room_count();
    }
    
    static void caculate_min_room_count(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].ed);

        for(int i = 1; i<N; i++){
            if(pq.peek()<=lectures[i].st) pq.poll();
            pq.add(lectures[i].ed);
        }
        System.out.println(pq.size());
    }
    
    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        lectures = new Lecture[N];
        for(int i = 0; i < N; i++){
            int num = sc.nextInt();
            int st = sc.nextInt();
            int ed = sc.nextInt();
            lectures[i] = new Lecture(st, ed);
        }
    }
}