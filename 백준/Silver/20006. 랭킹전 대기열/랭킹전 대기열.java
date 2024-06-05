import java.util.*;

public class Main {
    static int p, m;
    static ArrayList<Queue<String>> list = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        p = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i<p;i++){
            int level = sc.nextInt();
            String nickname = sc.next();
            map.put(nickname, level);

            if(list.isEmpty()||!isEnterValid(level)){
                list.add(new ArrayDeque<>());
                list.get(list.size()-1).add(nickname);
            }
            else{
                for(int k = 0; k<list.size();k++){
                    String roomOwnerNickname = list.get(k).peek();
                    int roomLevel = map.get(roomOwnerNickname);
                    int size = list.get(k).size();

                    if(size<m&&level-10<=roomLevel&&roomLevel<=level+10) {
                        list.get(k).add(nickname);
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<list.size();i++){
            Queue<String> queue = list.get(i);

            if(queue.size()==m) sb.append("Started!").append("\n");
            else sb.append("Waiting!").append("\n");
            PriorityQueue<String> pq = new PriorityQueue<>();

            while(!queue.isEmpty()){
                String nickname = queue.poll();
                pq.add(nickname);
            }
            while(!pq.isEmpty()){
                String nickname = pq.poll();
                int level = map.get(nickname);
                sb.append(level).append(" ").append(nickname);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static boolean isEnterValid(int userLevel){
        boolean check = false;
        for(int i = 0; i<list.size();i++){
            int size = list.get(i).size();
            String roomOwnerNickname = list.get(i).peek();
            int roomLevel = map.get(roomOwnerNickname);

            if(size<m&&userLevel-10<=roomLevel&&roomLevel<=userLevel+10) check = true;
        }
        if(check) return true;
        else return false;
    }
}