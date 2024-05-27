import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static int N,L;
    static int[][] map;
    static boolean[][] isSlope;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        map = new int[N][N];

        for(int r = 0;r<N;r++){
            for(int c= 0;c<N;c++){
                map[r][c] = sc.nextInt();
            }
        }
        for(int r =0;r<N;r++){
            isSlope = new boolean[N][N];
            findColPath(r,0,1);
        }
        for(int c =0;c<N;c++){
            isSlope = new boolean[N][N];
            findRowPath(0,c,1);
        }

        System.out.println(ans);
    }

    static void findColPath(int row,int col,int same){
        int cur = map[row][col];
        if(col == N-1) {
            ans++;
        }
        else{
            int next = map[row][col+1];
            if(Math.abs(next-cur)>=2) return;
            if(next == cur) findColPath(row, col+1,same+1);
            else if(next==cur-1){
                if(checkColDown(row, col)){
                    isSlope[row][col+L] = true;
                    findColPath(row, col+L,1);
                }
            }
            else if(next==cur+1){
                if(checkColUp(row,col,same)) findColPath(row, col+1,1);
            }
        }
    }
    static boolean checkColDown(int row, int col){
        for(int i = 1;i<=L;i++){
            if(col+L>=N||map[row][col+1]!=map[row][col+i]) return false;
        }
        return true;
    }

    static boolean checkColUp(int row, int col, int same){
        if(col-L+1<0||same<L) return false;
        for(int i = 0;i<L;i++){
            if(isSlope[row][col-i]) return false;
        }
        return true;
    }


    static void findRowPath(int row,int col,int same){
        int cur = map[row][col];
        if(row == N-1) {
            ans++;
        }
        else{
            int next = map[row+1][col];
            if(Math.abs(next-cur)>=2) return;
            if(next == cur) findRowPath(row+1, col,same+1);
            else if(next==cur-1){
                if(checkRowDown(row, col)){
                    isSlope[row+L][col] = true;
                    findRowPath(row+L, col,1);
                }
            }
            else if(next==cur+1){
                if(checkRowUp(row,col,same)) findRowPath(row+1, col,1);
            }
        }
    }

    static boolean checkRowDown(int row, int col){
        for(int i = 1;i<=L;i++){
            if(row+L>=N||map[row+1][col]!=map[row+i][col]) return false;
        }
        return true;
    }

    static boolean checkRowUp(int row, int col, int same){
        if(row-L+1<0||same<L) return false;
        for(int i = 0;i<L;i++){
            if(isSlope[row-i][col]) return false;
        }
        return true;
    }

}