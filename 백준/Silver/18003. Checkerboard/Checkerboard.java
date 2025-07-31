import java.util.Scanner;

public class Main {

    static int R,C,V,H;
    static boolean[] rows;
    static boolean[] cols;
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        V = sc.nextInt();
        H = sc.nextInt();

        rows = new boolean[R+1];
        cols = new boolean[C+1];
        map = new char[R][C];

        int r_point = 0, c_point = 0;
        for(int i = 0; i<V; i++){
            r_point+=sc.nextInt();
            rows[r_point] = true;
        }
        for(int i = 0; i<H; i++){
            c_point+=sc.nextInt();
            cols[c_point] = true;
        }

        char row_paint = 'B';
        for(int r = 0; r<R; r++){
            if(rows[r]){
                row_paint = row_paint == 'B' ? 'W': 'B';
            }
            char paint = row_paint;
            for(int c = 0; c<C; c++){
                if(cols[c]){
                    paint = paint == 'B' ? 'W': 'B';
                }
                map[r][c] = paint;
            }
        }

        for(int r = 0; r<R; r++){
            for(int c = 0; c<C; c++){
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
    }
}
