import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> map= new HashMap<>();
        Map<String, Integer> map2= new HashMap<>();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 1; i<=N; i++){
            String name = sc.next();
            map.put(i, name);
            map2.put(name, i);
        }
        for(int i =0; i<M; i++){
            String search = sc.next();
            if(isNumber(search)){
                int idx = Integer.parseInt(search);
                System.out.println(map.get(idx));
            }
            else{
                System.out.println(map2.get(search));
            }

        }

    }

    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

}