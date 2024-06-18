import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i<N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N-1;
        int cnt = 0;
        while(left<right){
            if(arr[left]+arr[right]==M){
                cnt++;
                right--;
            }
            else if(arr[left]+arr[right]>M) right--;
            else if(arr[left]+arr[right]<M) left++;
        }
        System.out.println(cnt);
    }
}