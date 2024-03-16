import java.util.Scanner;

public class Main {
    static int N;
    static char[][] stars;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        stars = new char[N][2*N-1];

        for(int r=0;r<N;r++){
            for(int c = 0; c<2*N-1;c++){
                stars[r][c] = ' ';
            }
        }
        draw(0,N-1,N);

        StringBuilder sb = new StringBuilder();
        for(int r=0;r<N;r++){
            for(int c = 0; c<2*N-1;c++){
                sb.append(stars[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static void draw(int r, int c, int n){
        if(n==3){
            stars[r][c] = '*';
            stars[r+1][c-1] = stars[r+1][c+1]= '*';
            stars[r+2][c-2] = stars[r+2][c-1] = stars[r+2][c] = stars[r+2][c+1] = stars[r+2][c+2] = '*';
            return;
        }
        draw(r,c,n/2);
        draw(r+n/2,c-n/2,n/2);
        draw(r+n/2,c+n/2,n/2);
    }
}