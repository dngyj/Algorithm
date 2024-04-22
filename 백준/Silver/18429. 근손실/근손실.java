import java.util.Scanner;

public class Main {

    static int N,K;
    static int[] kits;
    static int[] selected;
    static boolean[] visited;
    static int cnt=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        kits = new int[N];
        selected = new int[N];
        visited = new boolean[N];
        for(int i = 0;i<N;i++){
            kits[i] = sc.nextInt();
        }
        perm(0);
        System.out.println(cnt);
    }
    
    static void perm(int idx){
        if(idx==N){
            checkWeight(selected);
        }
        else{
            for(int i = 0; i<N;i++) {
                if(!visited[i]){
                    visited[i] = true;
                    selected[idx] = i;
                    perm(idx+1);
                    visited[i]= false;
                }
            }
        }
    }

    static void checkWeight(int[] selected){
        int now = 500;
        for(int i = 0;i<N;i++){
            now+=kits[selected[i]];
            now-=K;
            if(now<500) return;
        }
        cnt++;
    }
}