import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i<N; i++){
            String[] strs = sc.next().split("\\.");
            map.put(strs[1], map.getOrDefault(strs[1],0)+1);
        }

        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);

        for(String key : keyList){
            System.out.println(key+" "+map.get(key));
        }
    }
}
