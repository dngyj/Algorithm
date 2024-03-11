import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=0;tc<T;tc++){
            int N = sc.nextInt();
            ArrayList<int[]> list = new ArrayList<>();
            for(int i = 0;i<N+2;i++){
                int r = sc.nextInt();
                int c = sc.nextInt();
                list.add(new int[]{r,c});
            }

            boolean[][] flag = new boolean[N+2][N+2];
            for(int r=0;r<N+2;r++){
                for(int c=0;c<N+2;c++){
                    int[] now = list.get(r);
                    int[] next = list.get(c);
                    int dis = Math.abs(now[0]-next[0])+Math.abs(now[1]-next[1]);
                    if(dis<=1000) flag[r][c] = true;
                }
            }
            for(int k = 0; k<N+2;k++){
                for(int r=0;r<N+2;r++){
                    for(int c=0;c<N+2;c++){
                        if(flag[r][k]&&flag[k][c]) flag[r][c] = true;
                    }
                }
            }
            System.out.println(flag[0][N+1]?"happy":"sad");
        }
    }
}