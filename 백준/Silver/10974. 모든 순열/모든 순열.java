import java.util.Scanner;

public class Main {
    static int N;
    static int[] selected;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        selected = new int[N+1];
        visited = new boolean[N+1];
        perm(1,0);

    }
    static void perm(int idx, int depth){
        if(depth==N){
            for(int i = 1;i<N+1;i++){
                System.out.print(selected[i]+" ");
            }
            System.out.println();
        }
        else{
            for(int i = 1;i<N+1;i++){
                if(!visited[i]) {
                    visited[i] = true;
                    selected[idx] = i;
                    perm(idx+1, depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}