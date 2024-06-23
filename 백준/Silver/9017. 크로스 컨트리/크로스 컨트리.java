import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc=0;tc<T;tc++){
            int N = sc.nextInt();
            int[] teams = new int[N];

            Map<Integer,Integer> count = new HashMap<>();
            for(int i = 0; i<N;i++){
                int team = sc.nextInt();
                teams[i] = team;
                count.put(team, count.getOrDefault(team, 0)+1);
            }
            Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, Integer> map5 = new HashMap<>();
            int[] select = new int[count.size()+1];
            int[] fifth = new int[count.size()+1];
            int score = 1;

            for(int i = 0; i<N;i++){
                if(count.get(teams[i])<6) continue;
                select[teams[i]]++;
                if(select[teams[i]]<=4){
                    map.put(teams[i], map.getOrDefault(teams[i],0)+score);
                }
                if(select[teams[i]]==5){
                    fifth[teams[i]] = score;
                }
                score++;
            }

            int min = Integer.MAX_VALUE;
            for(Integer key: map.keySet()){
                min = Math.min(map.get(key),min);
            }
            int cnt = 0;
            int winner = -1;

            List<Integer> list = new ArrayList<>();

            for(Integer key: map.keySet()){
                if(map.get(key)==min){
                    cnt++;
                    winner = key;
                    list.add(key);
                }
            }
            if(cnt >= 2){
                int min5 = Integer.MAX_VALUE;
                for(int key:list){
                    if(fifth[key]<min5) {
                        min5 = fifth[key];
                        winner = key;
                    }
                }
            }
            System.out.println(winner);
        }
    }
}