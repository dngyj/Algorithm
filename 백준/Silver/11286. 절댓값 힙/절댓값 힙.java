import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if(Math.abs(o1)>Math.abs(o2)){
                    return 1;
                }else if(Math.abs(o1)==Math.abs(o2)){
                    return o1-o2;
                }
                return -1;
            }
        });
        int N = sc.nextInt();

        for(int i = 0; i<N;i++){
            int num = sc.nextInt();
            if(num==0){
                if(queue.isEmpty()) System.out.println(0);
                else System.out.println(queue.poll());
            }else{
                queue.add(num);
            }

        }
    }
}