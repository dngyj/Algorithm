import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N,M;
    static int[] parents,depths;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) {
        input();
        findDepthAndParents(1,1);
        outputCase();
    }

    static void input(){
        N = sc.nextInt();
        list = new ArrayList[N+1];
        for(int i = 0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        parents = new int[N+1];
        depths = new int[N+1];
        for(int i = 0;i<N-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        M = sc.nextInt();
    }
    static void findDepthAndParents(int cur, int depth){
        depths[cur] = depth;
        for(int next:list[cur]){
            if(depths[next]==0) {
                parents[next] = cur;
                findDepthAndParents(next, depth+1);
            }
        }
    }

    static void outputCase(){
        for(int i =0;i<M;i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println(findLCA(A,B));
        }
    }
    static int findLCA(int A, int B){
        while(depths[A]>depths[B]){
            A = parents[A];
        }
        while(depths[A]<depths[B]){
            B = parents[B];
        }
        while(A!=B){
            A = parents[A];
            B = parents[B];
        }
        return A;
    }
}