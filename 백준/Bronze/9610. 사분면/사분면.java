import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Point> inputList = new ArrayList<>();

        final int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] inputArr = br.readLine().split(" ");
            final int x = Integer.parseInt(inputArr[0]);
            final int y = Integer.parseInt(inputArr[1]);
            inputList.add(new Point(x, y));
        }
        System.out.print(solution(inputList));
    }

    public static String solution(List<Point> points) {
        StringBuilder sb = new StringBuilder();
        int q1 = 0;
        int q2 = 0;
        int q3 = 0;
        int q4 = 0;
        int axis = 0;

        for (Point point : points) {
            final int x = point.getX();
            final int y = point.getY();

            if (x == 0 || y == 0) {
                axis++;
            }
            if (x > 0 && y > 0) {
                q1++;
            }
            if (x < 0 && y > 0) {
                q2++;
            }
            if (x < 0 && y < 0) {
                q3++;
            }
            if (x > 0 && y < 0) {
                q4++;
            }
        }
        sb.append("Q1: ").append(q1).append("\n");
        sb.append("Q2: ").append(q2).append("\n");
        sb.append("Q3: ").append(q3).append("\n");
        sb.append("Q4: ").append(q4).append("\n");
        sb.append("AXIS: ").append(axis);

        return sb.toString();
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}