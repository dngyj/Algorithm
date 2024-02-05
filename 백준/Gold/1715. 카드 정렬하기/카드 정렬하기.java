import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i =0;i<N;i++){
            int num = sc.nextInt();
            queue.add(num);
        }
        int sum = 0;
        while(queue.size()>1){
            int num1 = queue.poll();
            int num2 = queue.poll();
            int temp = num1+num2;
            sum += temp;
            queue.add(temp);
        }
        System.out.println(sum);
    }
}