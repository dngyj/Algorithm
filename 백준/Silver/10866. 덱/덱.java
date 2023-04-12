import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> dq;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        dq = new ArrayDeque<Integer>();
        deque(N);
    }

    private static void deque(int n) throws IOException {
        Integer front, back;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    front = dq.pollFirst();
                    if (front != null) {
                        System.out.println(front);
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "pop_back":
                    back = dq.pollLast();
                    if (back != null) {
                        System.out.println(back);
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    if (dq.isEmpty() == true) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    front = dq.peekFirst();
                    if (front != null) {
                        System.out.println(front);
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "back":
                    back = dq.peekLast();
                    if (back != null) {
                        System.out.println(back);
                    } else {
                        System.out.println(-1);
                    }
                    break;
            }
        }
    }
}