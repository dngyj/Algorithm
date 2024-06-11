import java.util.*;

class Solution {
    
    
    public String[] solution(String[] record) {
        String[] answer;

        Queue<String[]> queue = new ArrayDeque<>();
        Map<String, String> map = new HashMap<>();
        
        for(int i = 0;i<record.length;i++){
            String[] str = record[i].split(" ");
            String order = str[0];
            String uid = str[1];
            
            if(order.equals("Leave")){
                queue.add(new String[]{order,uid});
            }
            if(order.equals("Change")){
                String nickname = str[2];
                map.put(uid, nickname);
            }
            if(order.equals("Enter")){
                String nickname = str[2];
                queue.add(new String[]{order,uid});
                map.put(uid, nickname);
            }
        }
        
        answer = new String[queue.size()];
        
        int idx = 0;
        while(!queue.isEmpty()){
            String[] str = queue.poll();
            String order = str[0];
            String uid = str[1];
            
            String status = "";
            if(order.equals("Enter")) status = "님이 들어왔습니다.";
            else status = "님이 나갔습니다.";
            
            String ans = map.get(uid)+status;
            answer[idx] = ans;
            idx++;
        }
        
        return answer;
    }
}