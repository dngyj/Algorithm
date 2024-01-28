import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] dist = new int[N][N];

        for(int i=0;i<K;i++){
            int st = sc.nextInt()-1;
            int ed = sc.nextInt()-1;
            dist[st][ed] = -1;
            dist[ed][st] = 1;
        }
        for(int k = 0; k<N;k++){
            for(int r=0;r<N;r++){
                for(int c=0; c<N;c++){
                    if(dist[r][k]>0&&dist[k][c]>0) dist[r][c] = dist[r][k]+dist[k][c];
                    if(dist[r][k]<0&&dist[k][c]<0) dist[r][c] = dist[r][k]+dist[k][c];
                }
            }
        }

        int S = sc.nextInt();
        for(int i =0;i<S;i++){
            int st = sc.nextInt()-1;
            int ed = sc.nextInt()-1;
            if(dist[st][st]>dist[st][ed]) System.out.println(-1);
            else if(dist[st][st]<dist[st][ed]) System.out.println(1);
            else System.out.println(0);
        }
    }
}