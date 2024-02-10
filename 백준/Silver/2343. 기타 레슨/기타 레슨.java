import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] lectures = new int[N];
        int right = 0;
        int left = 0;
        for(int i =0;i<N;i++){
            lectures[i] = sc.nextInt();
            right += lectures[i];
            left =Math.max(lectures[i],left);
        }

        while(left<=right){
            int mid = (left+right)/2;
            int cnt = 0;
            int sum = 0;
            for(int i =0;i<N;i++){
                if(sum+lectures[i]>mid){
                    sum=0;
                    cnt++;
                }
                sum+=lectures[i];
            }
            if(sum>0) cnt++;

            if(cnt>M){
                left = mid +1;
            }
            else right = mid-1;
        }
        System.out.println(left);
    }
}