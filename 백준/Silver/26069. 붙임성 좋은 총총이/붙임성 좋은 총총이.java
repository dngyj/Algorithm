import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i<N;i++){
            String A = sc.next();
            String B = sc.next();

            if(A.equals("ChongChong")||B.equals("ChongChong")){
                map.put(A,1);
                map.put(B,1);
            }
            if(map.containsKey(A)|| map.containsKey(B)){
                map.put(A,1);
                map.put(B,1);
            }
        }
        System.out.println(map.size());
    }
}