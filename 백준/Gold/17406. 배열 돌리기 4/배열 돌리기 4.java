import java.util.Scanner;

public class Main {

    static int N, M,K;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] cal;
    static int[][] temp;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        map = new int[N][M];
        temp = new int[N][M];
        for(int r = 0; r<N;r++){
            for(int c = 0; c<M; c++){
                map[r][c] = sc.nextInt();
            }
        }

        cal = new int[K][3];
        for(int i =0;i<K;i++){
           cal[i][0] = sc.nextInt()-1;
           cal[i][1] = sc.nextInt()-1;
           cal[i][2] = sc.nextInt();
        }
        perm(0, new int[K], new boolean[K]);

        System.out.println(min);

    }

    public static void perm(int cnt, int[] arr, boolean[] visited){

        if(cnt==K){
            rotate(arr);
            return;
        }
        for(int i = 0; i<K; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[cnt] = i;
            perm(cnt+1,arr,visited);
            visited[i] = false;
        }
    }

    public static void rotate(int[] arr){
        for(int r = 0; r<N;r++){
            for(int c = 0; c<M; c++){
                temp[r][c] = map[r][c];
            }
        }

        for(int i=0;i<K;i++){
            int row = cal[arr[i]][0];
            int col = cal[arr[i]][1];
            int S = cal[arr[i]][2];

            for(int s=1;s<=S;s++){
                //위
                int tempUp = temp[row-s][col+s];
                for(int c=col+s; c>col-s;c--){
                    temp[row-s][c] = temp[row-s][c-1];
                }
                //오
                int tempRight = temp[row+s][col+s];
                for(int r= row+s; r>row-s;r--){
                    temp[r][col+s] = temp[r-1][col+s];
                }
                temp[row-s+1][col+s] = tempUp;
                //아래
                int tempLeft = temp[row+s][col-s];
                for(int c=col-s;c<col+s;c++){
                    temp[row+s][c] = temp[row+s][c+1];
                }
                temp[row+s][col+s-1] = tempRight;
                //좌
                for(int r=row-s;r<row+s;r++){
                    temp[r][col-s] = temp[r+1][col-s];
                }
                temp[row+s-1][col-s] = tempLeft;
            }

        }

        for(int r=0; r<N;r++){
            int sum = 0;
            for(int c=0;c<M;c++){
                sum +=temp[r][c];
            }
            min = Math.min(min, sum);
        }

    }

}