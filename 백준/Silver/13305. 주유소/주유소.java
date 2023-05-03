import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] km = new int[N-1]; // 도로의 길이
        int[] oil = new int[N]; // 도시별 기름 가격

        for(int i = 0; i<N-1;i++){
            km[i] = sc.nextInt();
        }

        for(int i=0; i<N-1;i++){
            oil[i] = sc.nextInt();
        }
        sc.nextInt();

        int min=Integer.MAX_VALUE;
        long cost = 0;
        for(int i=0;i<N-1;i++){
            min=Math.min(oil[i],min);
            cost +=min*km[i];
        }
        System.out.println(cost);
    }
}