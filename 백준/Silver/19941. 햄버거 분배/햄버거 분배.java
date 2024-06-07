import java.util.Scanner;

public class Main {
    static char[] table;
    static boolean[] visited;
    static int N,K;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        table = sc.next().toCharArray();
        visited = new boolean[N];

        for(int i = 0;i<N;i++){
            if(table[i]=='P'){
                for(int k=-K;k<=K;k++){
                    int idr = i+k;
                    if(idr<0||idr>=N) continue;
                    if(!visited[idr]&&table[idr]=='H'){
                        visited[idr] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}