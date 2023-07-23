import java.util.*; 

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String s = Integer.toString(n, k);
        String[] nums = s.split("0");
        
        for(int i = 0; i<nums.length;i++){
            // System.out.println(nums[i]);
            
            if(!nums[i].equals("")){
                
                if(nums[i].equals("1")) {
                    continue;
                }
                
                if(nums[i].equals("2")) {
                    answer++;
                }
                else{
                    for(int div = 2; div<=Math.ceil(Math.sqrt(Long.parseLong(nums[i])))+1;div++){
                        // if(div==Long.parseLong(nums[i])) answer++;
                        if((Long.parseLong(nums[i]))%div==0) break;
                        else if(div==Math.ceil(Math.sqrt(Long.parseLong(nums[i])))){
                        answer++;
                        // break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}