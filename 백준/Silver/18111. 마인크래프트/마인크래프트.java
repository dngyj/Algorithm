import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int N, M, B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

        for(int r = 0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c<M; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                high = Math.max(map[r][c],high);
                low = Math.min(map[r][c],low);
            }
        }

        int time = Integer.MAX_VALUE;
        int flat = 0;

        for(int height=low; height<=high;height++){
            int waste = 0;
            int block = B;

            for(int r = 0; r<N; r++){
                for(int c = 0; c<M; c++){
                    if(map[r][c] > height){
                      waste += 2*(map[r][c]-height);
                      block+=(map[r][c]-height);
                    }
//                    System.out.println(height+","+block);
                    if(map[r][c]<height){
                        waste += (height-map[r][c]);
                        block-=(height-map[r][c]);
                    }
                }
            }
            if(block>=0&&waste<=time) {
                time = Math.min(time, waste);
                flat = height;
            }
        }
        System.out.print(time+" "+flat);
    }

}