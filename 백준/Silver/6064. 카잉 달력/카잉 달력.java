import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=0;tc<T;tc++){
            int M = sc.nextInt();
            int N = sc.nextInt();
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            boolean flag = false;

            for(int i = x; i<N*M;i+=M){
                if(i%N==y){
                    System.out.println(i+1);
                    flag = true;
                    break;
                }
            }
            if(!flag) System.out.println(-1);
        }
    }
}