import java.util.*;

class Solution {
    
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer;
        answer = new int[query.length];
        
        for(String eachInfo:info){
            String[] people = eachInfo.split(" ");
            makeSentence(0, people, "");
        }
        
        for(String key: map.keySet()){
            Collections.sort(map.get(key));
        }
        
        int idx = 0;
        for(String qry:query){
            qry = qry.replace(" and ", "");
            String[] q = qry.split(" ");
            answer[idx] = map.containsKey(q[0])? binarySearch(q[0], Integer.parseInt(q[1])):0;
            idx++;
        }
        
        
        return answer;
    }
    
    static int binarySearch(String key, int score){
        ArrayList<Integer> list = map.get(key);
        
        int left = 0;
        int right = list.size()-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            
            if(list.get(mid)<score) left = mid+1;
            else right = mid-1;
        }
        return list.size()-left;
        
    }
    
    static void makeSentence(int idx, String[] people, String s){
        if(idx==4){
            if(!map.containsKey(s)){
                ArrayList<Integer> list = new ArrayList<>();
                map.put(s,list);
            }
            map.get(s).add(Integer.parseInt(people[4]));
        }        
        else{
            makeSentence(idx+1, people, s+"-");
            makeSentence(idx+1, people, s+people[idx]);          
        }
    }
}