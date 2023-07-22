import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        StringBuilder sb = new StringBuilder();
        
        map.put("R",0);
        map.put("T",0);
        map.put("C",0);
        map.put("F",0);
        map.put("J",0);
        map.put("M",0);
        map.put("A",0);
        map.put("N",0);
        
        for(int i = 0; i<survey.length;i++){
            String disagree = survey[i].substring(0,1);
            String agree = survey[i].substring(1,2);
            
            if(choices[i]<4){
                map.put(disagree, map.get(disagree)+4-choices[i]); 
            }
            if(choices[i]>4){
                 map.put(agree, map.get(agree)+choices[i]-4);
            }
          
            // System.out.println(disagree+" "+ agree);
        }
        // for(String key : map.keySet()){
        // Integer value = map.get(key);
        // System.out.println(String.format("키 : "+key+", 값 : "+value));
        // }
        
        
        if(map.get("R")>=map.get("T")) sb.append("R");
        else sb.append("T");
        
        if(map.get("C")>=map.get("F")) sb.append("C");
        else sb.append("F");
        
        if(map.get("J")>=map.get("M")) sb.append("J");
        else sb.append("M");
        
        if(map.get("A")>=map.get("N")) sb.append("A");
        else sb.append("N");
        
        answer = sb.toString();
        // System.out.println(sb.toString());
        
        return answer;
    }
}