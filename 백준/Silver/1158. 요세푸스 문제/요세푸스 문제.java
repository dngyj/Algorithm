import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
  
        Queue<Integer> q = new LinkedList<>();

        int N = in.nextInt();
        int K = in.nextInt();

        for(int i =1;i<=N;i++) {
            q.add(i);
        }

        StringBuilder people = new StringBuilder();
        people.append('<');

        while (q.size()>1) {

            for(int i =0; i<K-1;i++) {
                int value = q.poll();
                q.offer(value);
            }
            people.append(q.poll()).append(", ");
        }

        people.append(q.poll()).append('>');
        System.out.println(people);
    }
}