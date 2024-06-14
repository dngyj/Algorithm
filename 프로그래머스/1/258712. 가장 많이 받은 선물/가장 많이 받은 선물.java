import java.util.*;

class Solution {
    
    static int[][] record;
    static int[] presentIndex;
    static int len;
    static Map<String, Integer> map = new HashMap<>();
    static int answer = -1;
    
    public int solution(String[] friends, String[] gifts) {
        len = friends.length;
        setValue(friends, gifts);
        getMaxNextPresent();
        return answer;
    }

    
    static void setValue(String[] friends, String[] gifts){
        for(int i = 0; i<len;i++){
            map.put(friends[i], i);
        }
        
        record = new int[len][len];
        presentIndex = new int[len];
        
        for(int i = 0; i<gifts.length;i++){
            String[] name = gifts[i].split(" ");
            String giver = name[0];
            String receiver = name[1];
            int gIdx = map.get(giver);
            int rIdx = map.get(receiver);
            record[gIdx][rIdx]++;
            presentIndex[gIdx]++;
            presentIndex[rIdx]--;
        }
    }
    
    static void getMaxNextPresent(){
          for(int i = 0; i<len-1;i++){
            int cnt = 0;
            for(int j = 0; j<len; j++){
                if(i==j) continue;
                if(record[i][j]>record[j][i]) cnt++;
                else if(record[i][j] == record[j][i]&& presentIndex[i]>presentIndex[j]) cnt++;
            }
            answer = Math.max(answer, cnt);
        }
    }
    
}