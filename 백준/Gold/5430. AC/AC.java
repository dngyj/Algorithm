import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {

            Deque<Integer> deque = new ArrayDeque<>();
            String commands = sc.next();
            int N = sc.nextInt();

            String str = sc.next();
            StringTokenizer st = new StringTokenizer(str, "[],");
            for (int i = 0; i < N; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            AC(commands, deque);
        }
    }

    static void AC(String commands, Deque<Integer> deque) {

        boolean reverse = false;
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'R') {
                reverse = !reverse;
            }
            if (command == 'D') {
                if (deque.size() == 0) {
                    System.out.println("error");
                    return;
                }
                if (reverse) deque.removeLast();
                else deque.removeFirst();
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!deque.isEmpty()) {
            sb.append(reverse ? deque.pollLast() : deque.pollFirst());
            if(deque.size()!=0) sb.append(",");
        }
        sb.append("]");
        System.out.println(sb);
    }
}