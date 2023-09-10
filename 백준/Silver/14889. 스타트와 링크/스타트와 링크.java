import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;

    static int[][] abilities;
    static int N;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        abilities = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j=0;str.hasMoreTokens();j++){
                abilities[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        comb(0,0);

        System.out.println(min);

    }

    static void comb(int depth, int st){

        if(depth==N/2){
            diff();
            return;
        }

        for(int i=st;i<N;i++){
            visited[i] = true;
            comb(depth+1,i+1);
            visited[i] = false;
        }
    }

    private static void diff() {

        int Tstart = 0;
        int Tlink = 0;

        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(visited[i]==true&&visited[j]==true){
                    Tstart += abilities[i][j];
                    Tstart += abilities[j][i];
                }
                else if(visited[i]==false&&visited[j]==false){
                    Tlink += abilities[i][j];
                    Tlink += abilities[j][i];
                }
            }
        }

        int value = Math.abs(Tstart-Tlink);

        min = Math.min(min,value);

    }

}