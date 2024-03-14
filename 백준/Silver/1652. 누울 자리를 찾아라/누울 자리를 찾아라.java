import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] map = new char[N][N];
        boolean[][] visited = new boolean[N][N];
        for(int r=0;r<N;r++){
            String str = sc.next();
            for(int c = 0; c<N;c++){
                map[r][c] = str.charAt(c);
            }
        }
        int col = 0;
        int row = 0;
        int ans1 = 0;
        int ans2 = 0;
        for(int r = 0; r<N;r++){
            col=0; row = 0;
            for(int c=0;c<N;c++){
                if(map[r][c]=='.') col++;
                if(map[r][c]=='X'||c==N-1) {
                    if (col >= 2) ans1++;
                    col = 0;
                }
                if(map[c][r]=='.') row++;
                if(map[c][r]=='X'||c==N-1) {
                    if (row >= 2) ans2++;
                    row = 0;
                }
                
            }
        }
        System.out.println(ans1+" "+ans2);
    }
}