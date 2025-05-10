import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        Map<String, Integer> map = new HashMap<>();
        int length = players.length;        
        
        for(int i = 0; i<length; i++){
            map.put(players[i], i);
        }
        
        ArrayList<String> list = new ArrayList<>(Arrays.asList(players));
        
        for(String calling : callings){
            int index = map.get(calling);
            String tempPlayer = list.get(index-1);
            
            Collections.swap(list, index, index-1);
            
            map.put(calling, index-1);
            map.put(tempPlayer, index);
        }
        
        answer = list.toArray(new String[list.size()]);
        return answer;
    }
}