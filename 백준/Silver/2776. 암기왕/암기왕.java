import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=0;tc<T;tc++){
            int N = sc.nextInt();
            int[] note1 = new int[N];
            for(int i = 0; i<N;i++){
                note1[i] = sc.nextInt();
            }
            Arrays.sort(note1);
            int M = sc.nextInt();

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<M;i++){
                flag = false;
                int note2 = sc.nextInt();
                binarySearch(note2, note1 ,N);
                sb.append(flag ? 1 : 0).append("\n");
            }
            System.out.print(sb);
        }
    }

    static void binarySearch(int note2, int[] note1 , int N){
        int left = 0;
        int right = N-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(note2>note1[mid]){
                left = mid+1;
            }
            else if(note2<note1[mid]){
                right = mid-1;
            }
            else{
                flag = true;
                break;
            }
        }
    }
}