import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        int N  = sc.nextInt();

        for(int i = 0;i<N;i++){
            String name = sc.next();
            if(map.containsKey(name)) map.put(name,map.get(name)+1);
            else map.put(name,1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2)-map.get(o1);
            }
        });

        System.out.println(keySet.get(0));
    }
}