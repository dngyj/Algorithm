import java.util.*;

class Solution {
    
    static HashMap<String, Integer> map;
    static int[] courseMax;
    static boolean[] selected;
    static int orderLen;
    static char[] order;
    static ArrayList<String> ans = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        
        courseMax = new int[course.length];
        map = new HashMap<>();
        
        for(int i = 0; i<orders.length;i++){
            order = orders[i].toCharArray();
            Arrays.sort(order);
            orderLen = order.length;
            
            for(int j = 0; j<course.length;j++){
                selected = new boolean[orderLen];
                comb(0,0,course[j], "", j);
            }
        }
        
        for(String s: map.keySet()){
            for(int j = 0; j<course.length;j++){
               if(courseMax[j]>1&&course[j]==s.length()&&courseMax[j]==map.get(s)){
                   ans.add(s);
               }
            }
        }
        Collections.sort(ans);
        
        answer = new String[ans.size()];
        for(int i = 0; i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    static void comb(int idx, int cnt, int N, String s, int j){
        if(cnt == N){
            map.put(s, map.containsKey(s)?map.get(s)+1:1);
            courseMax[j] = Math.max(courseMax[j], map.get(s));
        }
        else{
            for(int i = idx; i<orderLen;i++){
                comb(i+1, cnt+1, N, s+order[i], j);
            }
        }
    } 
}