import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
    
        HashMap<String, Integer> map = new HashMap<>();
        
        int maxLen = -1;
        for(String p : phone_book){
            map.put(p,1); 
        }
        outer: for(String p : phone_book){
            for(int i=0;i<p.length();i++){
                String prestr = p.substring(0,i);
                if(map.containsKey(prestr)){
                    answer = false;
                    break outer;
                } 
            }
        }

        return answer;
    }
}