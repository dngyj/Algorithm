import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int r = 0; r<N;r++){
            for(int c= 0; c<N;c++){
                int num = sc.nextInt();
                if(queue.size()<N) queue.add(num);
                else{
                    if(queue.peek()<num) {
                        queue.poll();
                        queue.add(num);
                    }
                }
            }
        }
        System.out.println(queue.peek());
    }
}