import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static ArrayList<pos> list = new ArrayList<>();
    static ArrayList<pos> house = new ArrayList<>();
    static pos[] selected;
    static int chickenDistance;
    static int ans = Integer.MAX_VALUE;
    static class pos {
        int r;
        int c;

        public pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        selected = new pos[M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = sc.nextInt();
                if (map[r][c] == 2) list.add(new pos(r, c));
                if (map[r][c] == 1) house.add(new pos(r, c));
            }
        }
        comb(0, 0);
        System.out.println(ans);
    }

    public static void comb(int depth, int idx) {
        if (depth == M) {
            calculate();
            ans = Math.min(chickenDistance,ans);
            return;
        }
        for (int i = idx; i < list.size(); i++) {
            selected[depth] = list.get(i);
            comb(depth + 1, i + 1);
        }
    }

    public static void calculate() {
        chickenDistance = 0;
        for (int k = 0; k < house.size(); k++) {
            int R = house.get(k).r;
            int C = house.get(k).c;

            min = Integer.MAX_VALUE;
            for (int i = 0; i < M; i++) {
                int chickenR = selected[i].r;
                int chickenC = selected[i].c;
                int distance = Math.abs(chickenR-R)+Math.abs(chickenC-C);
                min = Math.min(min, distance);
            }
            chickenDistance += min;
        }
    }
}