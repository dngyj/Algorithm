import java.util.Scanner;

public class Main {
    static String[] str;
    static int N;
    static int min;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            min = Integer.MAX_VALUE;
            N = sc.nextInt();
            str = new String[N];
            for (int n = 0; n < N; n++) {
                str[n] = sc.next();
            }
            if (N > 32) System.out.println(0);
            else {
                comb(0, new int[3], new boolean[N]);
                System.out.println(min);
            }
        }

    }

    public static void comb(int cnt, int[] arr, boolean[] visited) {

        if (cnt == 3) {
            calculate(arr);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[cnt] = i;
            comb(cnt + 1, arr, visited);
            visited[i] = false;
        }
    }

    public static void calculate(int[] arr) {

        int cnt = 0;
        String str1 = str[arr[0]];
        String str2 = str[arr[1]];
        String str3 = str[arr[2]];

        for (int i = 0; i < 4; i++) {
            if (str1.charAt(i) != str2.charAt(i)) cnt++;
        }
        for (int i = 0; i < 4; i++) {
            if (str2.charAt(i) != str3.charAt(i)) cnt++;
        }
        for (int i = 0; i < 4; i++) {
            if (str1.charAt(i) != str3.charAt(i)) cnt++;
        }
        min = Math.min(min, cnt);
    }
}