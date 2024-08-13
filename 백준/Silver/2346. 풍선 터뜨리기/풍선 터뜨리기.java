import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int move = sc.nextInt();

        for(int i = 1; i<N;i++){
            int num = sc.nextInt();
            deque.add(new int[]{i+1, num});
        }

        sb.append(1+" ");
        while(!deque.isEmpty()){
            if(move<0){
                for(int i = 1; i<-move;i++){
                    deque.addFirst(deque.pollLast());
                }
                int[] cur = deque.pollLast();
                move = cur[1];
                sb.append(cur[0]+" ");
            }
            else{
                for(int i = 1; i<move;i++){
                    deque.addLast(deque.poll());
                }
                int[] cur = deque.poll();
                move = cur[1];
                sb.append(cur[0]+" ");
            }
        }
        System.out.println(sb.toString());
    }
}