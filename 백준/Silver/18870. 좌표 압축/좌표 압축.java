import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] arrSort = new int[N];

        for(int i = 0 ; i<N; i++){
            arr[i] = sc.nextInt();
            arrSort[i] = arr[i];
        }

        Arrays.sort(arrSort);

        Map<Integer, Integer> indexMap = new HashMap<>();
        int index = 0;
        for (int i = 0; i < N; i++) {
            if(!indexMap.containsKey(arrSort[i])){
                indexMap.put(arrSort[i], index++);
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(indexMap.get(arr[i])).append(" ");
        }
        System.out.println(sb);
    }
}