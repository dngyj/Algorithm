import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t<T;t++){
            int tc = sc.nextInt();
            int max = -1;
            int[] arr = new int[21];
            int count = 0;
            for(int i = 1;i<=20;i++){
                int num = sc.nextInt();
                if(num>max) {
                    arr[i] = num;
                    max = num;
                }
                else{
                    int insertIdx = -1;
                    for(int j=i-1;j>=0;j--){
                        if(arr[j]<num) {
                            insertIdx = j+1;
                            break;
                        }
                    }
                    for(int j=i-1; j>=insertIdx; j--){
                        arr[j+1] = arr[j];
                        count++;
                    }
                    arr[insertIdx] = num;
                }
            }
            System.out.println(tc+" "+count);
        }
    }
}