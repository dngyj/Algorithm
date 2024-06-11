import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i<N;i++){
            arr[i] = sc.nextInt();
        }
        LinkedList<Integer> list = new LinkedList<>();
        list.add(N);
        for(int i = N-2;i>=0;i--){
            int idx = arr[i];
            list.add(idx,i+1);
        }
        for(int i = 0; i<N;i++){
            System.out.print(list.get(i)+" ");
        }
    }
}