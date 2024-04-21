import java.util.Scanner;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();

    static boolean[] visited;
    static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N];
        selected = new int[M];

        powerset(0);
        System.out.println(sb);
    }

    public static void powerset(int index){

        if(index == M){
            for(int i = 0 ; i<M; i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        else{
            for(int i = 0; i<N;i++){
                if(!visited[i]){
                    selected[index] = i+1;
                    visited[i] = true;
                    powerset(index+1);
                    visited[i] = false;
                }
            }
        }
    }

}