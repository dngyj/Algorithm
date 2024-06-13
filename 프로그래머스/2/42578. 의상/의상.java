import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();
        for(int r = 0 ; r<clothes.length;r++){
            String value = clothes[r][0];
            String key = clothes[r][1];
            map.put(key, map.getOrDefault(key,0)+1);
        }
        
        answer = 1;
        for(String key:map.keySet()){
            answer*=(map.get(key)+1);
        }
        answer -=1;
        
        
        return answer;
    }
}