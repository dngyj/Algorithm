import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int newScore = sc.nextInt();
        int P = sc.nextInt();

        int[] scores = new int[N];
        for(int i = 0;i<N;i++){
            scores[i] = sc.nextInt();
        }
        if(N==P&&scores[N-1]>=newScore){
            System.out.println(-1);
        }else{
            int rank = 1;
            for(int i = 0;i<N;i++){
                if(scores[i]>newScore) rank++;
                else break;
            }
            System.out.println(rank);
        }
    }
}