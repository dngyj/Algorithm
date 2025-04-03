import java.util.Scanner;

public class Main {

    static int N, K;
    static int[] costs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        costs = new int[N];
        int maxCost = 0;

        for (int i = 0; i < N; i++) {
            costs[i] = sc.nextInt();
            maxCost = Math.max(maxCost, costs[i]);
        }

        int left = 1;
        int right = maxCost;
        int answer = maxCost;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canAccept(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean canAccept(int mid) {
        int rejectCount = 0;

        for (int i = 0; i < N; i++) {
            if (costs[i] > mid) {
                rejectCount++;
                if (rejectCount >= K) {
                    return false;
                }
            } else {
                rejectCount = 0;
            }
        }
        return true;
    }
}