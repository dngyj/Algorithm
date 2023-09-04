import java.util.Scanner;

public class Main {

    static int N, K;
    static StringBuilder sb;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            sb = new StringBuilder();

            N = sc.nextInt();
            K = (int)Math.pow(3, N);

            for(int i = 0; i<K;i++){
                sb.append("-");
            }
            recur(0, K);

            System.out.println(sb);
        }
    }

    private static void recur(int st, int K) {

        if(K==1){
            return;
        }
        else{
            K = K/3;

            for(int i=st+K;i<st+2*K;i++){
                sb.setCharAt(i, ' ');
            }

            recur(st, K);
            recur(st+2*K,K);
        }

    }
}