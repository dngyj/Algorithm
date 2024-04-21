import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static int N,K;
    static int[] cards;
    static int[] selected;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        cards = new int[N];
        visited = new boolean[N];
        selected = new int[N];
        for(int i = 0;i<N;i++){
            cards[i] = sc.nextInt();
        }
        perm(0);
        System.out.println(set.size());
    }

    static void perm(int idx){
        if(idx==K){
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<K;i++) {
                sb.append(cards[selected[i]]);
            }
            set.add(sb.toString());
        }
        else{
            for(int i = 0;i<N;i++){
                if(!visited[i]){
                    visited[i] = true;
                    selected[idx] = i;
                    perm(idx+1);
                    visited[i] = false;
                }
            }
        }
    }
}