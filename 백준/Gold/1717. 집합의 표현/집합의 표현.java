import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        p = new int[N+1];
        for(int i=0;i<N+1;i++){
            p[i] = i;
        }

        for(int i = 0; i<M;i++){
            int state = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(state==0){
                if(a>b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                union(a,b);
            }
            else if(state==1){
                if(findset(a)==findset(b)){
                    System.out.println("YES");
                }
                else System.out.println("NO");
            }
        }
    }

    private static void union(int a, int b) {
        p[findset(b)]=findset(a);
    }

    static int findset(int x){
        if(p[x]!=x){
            p[x] = findset(p[x]);
        }
        return p[x];
    }
}