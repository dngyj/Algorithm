import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] dist = new int[N][N];
        for(int i =0;i<M;i++){
            int st = sc.nextInt()-1;
            int ed =sc.nextInt()-1;
            dist[st][ed] = 1;
            dist[ed][st] = -1;
        }


        for(int k = 0;k<N;k++){
            for(int r = 0;r<N;r++){
                for(int c= 0;c<N;c++){
                    if(dist[r][k]>0&&dist[k][c]>0) dist[r][c] = dist[r][k]+dist[k][c];
                    if(dist[r][k]<0&&dist[k][c]<0) dist[r][c] = dist[r][k]+dist[k][c];
                }
            }
        }

        int ans = 0;
        for(int r=0;r<N;r++){
            int cnt1 = 0;
            int cnt2 = 0;
            for(int c=0;c<N;c++){
                if(r!=c){
                    if(dist[r][c]>0) cnt1++;
                    if(dist[r][c]<0) cnt2++;
                }
            }
            if(cnt1>=N/2+1) ans++;
            if(cnt2>=N/2+1) ans++;
        }
        System.out.println(ans);
    }
}