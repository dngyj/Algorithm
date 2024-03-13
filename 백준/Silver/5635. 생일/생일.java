import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer,String> map = new HashMap<>();
        int N = sc.nextInt();
        int old = 20200000;
        int young = -1;
        
        for(int i = 0; i<N;i++) {
            String name = sc.next();
            int dd = sc.nextInt();
            int mm = sc.nextInt();
            int yyyy = sc.nextInt();
            int birth = yyyy * 10000 + mm * 100 + dd;
            young = Math.max(young, birth);
            old = Math.min(old, birth);
            map.put(birth, name);
        }
        System.out.println(map.get(young));
        System.out.println(map.get(old));
    }
}