import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] parents;
    static boolean check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        parents = new int[N+1];
        for(int i = 0;i<N+1;i++){
            parents[i] = i;
        }
        for(int i = 0; i<M;i++){
            if(check) continue;
            int a = sc.nextInt();
            int b = sc.nextInt();
            int temp;
            if(a>b){
                temp = a;
                a = b;
                b = temp;
            }
            check = false;
            union(a, b);
            if(check) System.out.println(i+1);
        }
        if(!check) System.out.println(0);
    }

    static void union(int a, int b){
        if(findset(a)==findset(b)) check = true;
        parents[findset(b)] = findset(a);
    }

    static int findset(int x){
        if(x!=parents[x]){
            return findset(parents[x]);
        }
        else return parents[x]=x;
    }


}