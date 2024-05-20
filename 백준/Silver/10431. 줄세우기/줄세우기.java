import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t<T;t++){
            int tc = sc.nextInt();
            int[] arr = new int[20];
            for(int i = 0;i<20;i++) {
                arr[i] = sc.nextInt();
            }
            int count = 0;
            for(int j=0;j<20;j++){
                for(int k=0;k<j;k++){
                    if(arr[j]<arr[k]) count++;
                }
            }
            System.out.println(tc+" "+count);
        }
    }
}