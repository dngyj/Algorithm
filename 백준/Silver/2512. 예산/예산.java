import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] budgets = new int[N];
        int max = -1;
        for(int i =0;i<N;i++){
            budgets[i] = sc.nextInt();
            max = Math.max(max, budgets[i]);
        }

        int need  = sc.nextInt();
        int min = 0;

        while(min<=max){
            int mid = (min+max)/2;
            long sum=0;
            for(int i =0;i<N;i++){
                long budget = 0;
                if(mid>=budgets[i]) budget = budgets[i];
                else budget = mid;
                sum+= budget;
            }
            if(sum<=need){
                min = mid+1;
            }
            else max = mid-1;
        }
        System.out.println(max);
    }
}