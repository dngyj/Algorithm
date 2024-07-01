import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;
        while(left<=N){
            if(sum==N){
                cnt++;
                sum+=right;
                right++;
            }
            if(sum<N){
                sum+=right;
                right++;
            }
            if(sum>=N){
                sum-=left;
                left++;
            }
        }
        System.out.println(cnt);
    }
}