import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> keyList = new ArrayList<>();

        for(int i = 0; i<N; i++){
            String[] strs = sc.next().split("\\.");
            map.put(strs[1], map.getOrDefault(strs[1],0)+1);
        }

        for(String key:map.keySet()){
            keyList.add(key);
        }

        String[] keys = keyList.toArray(new String[0]);
        Arrays.sort(keys);
        
        for(String key : keys){
            System.out.println(key+" "+map.get(key));
        }
    }
}
