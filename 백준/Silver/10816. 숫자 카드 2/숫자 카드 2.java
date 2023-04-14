import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static int M, N;
    static HashMap<Integer, Integer> map;


    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);

        map = new HashMap<>();

        M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }

        N = sc.nextInt();
        for (int i=0; i<N;i++){
            int num = sc.nextInt();
            if(map.containsKey(num)) sb.append(map.get(num)+" ");
            else sb.append(0 + " ");
        }
        System.out.println(sb.toString());
    }

}