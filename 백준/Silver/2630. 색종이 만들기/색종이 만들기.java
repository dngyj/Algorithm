import java.util.Scanner;

public class Main {

    static int N;
    static int[][] paper;
    static int white;
    static int blue;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        paper = new int[N][N];

        for(int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                paper[i][j] = sc.nextInt();
            }
        }

        white = 0;
        blue = 0;

        curr(0, 0, N, paper);

        System.out.println(white);
        System.out.println(blue);

    }

    private static void curr(int r, int c, int size, int[][] paper) {

        if(size==1){
            if(paper[r][c]==0) white++;
            else if(paper[r][c]==1) blue++;
            return;
        }

        if (check(r,c,size,paper)&&size>1){
            if(paper[r][c]==0) white++;
            else if(paper[r][c]==1) blue++;
            return;
        }


        if(!check(r,c,size,paper)){
            curr(r, c,size/2, paper);
            curr(r, c+size/2, size/2, paper);
            curr(r+size/2, c,size/2, paper);
            curr(r+size/2, c+size/2, size/2, paper);
        }
    }

    private static boolean check(int r, int c, int size, int[][] paper){

        for(int i =r; i<r+size;i++){
            for(int j=c;j<c+size;j++) {
                if (paper[r][c] != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}