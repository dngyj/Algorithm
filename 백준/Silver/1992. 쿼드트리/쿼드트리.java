import java.util.Scanner;

public class Main {

    static int N;
    static int[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        video = new int[N][N];

        for(int r=0; r<N; r++){
            String str = sc.next();
            for(int c=0; c<N;c++){
               video[r][c] = str.charAt(c)-'0';
            }
        }

        compress(0, 0, N);
        System.out.println(sb);

    }

    private static void compress(int r, int c, int size) {

        if(check(r, c, size)){
            sb.append(video[r][c]);
        }
        else{
            int half = size/2;
            sb.append("(");
            compress(r,c,half);
            compress(r,c+half,half);
            compress(r+half, c, half);
            compress(r+half,c+half,half);
            sb.append(")");
        }
    }

    private static boolean check(int r, int c, int size) {
        if(size==1){
            return true;
        }
        else{
            for(int i=r;i<r+size;i++){
                for(int j=c;j<c+size;j++){
                    if(video[i][j]!=video[r][c]) return false;
                }
            }
            return true;
        }
    }
}