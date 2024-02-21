import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Map<String, String> map = new HashMap();
        Set<String> names = new HashSet<>();
        for(int i =0;i<N;i++){
            String name = sc.next();
            String state = sc.next();
            map.put(name, state);
            names.add(name);
        }
        ArrayList<String> people = new ArrayList<>();
        for(String name:names){
            if(map.get(name).equals("enter")){
                people.add(name);
            }
        }
        Collections.sort(people, Collections.reverseOrder());
        for(String name : people){
            System.out.println(name);
        }
    }
}