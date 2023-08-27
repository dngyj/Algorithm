class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int least = 0;
        int change = 0;
        
        for(int i = 0; i<6;i++){
            for(int j = 0; j<6;j++){
                if(lottos[i]==win_nums[j]) least++;
            }
            if(lottos[i]==0) change++;
        }     
        int leastRank = 0;
        int maxRank = 0;
        
        if(least<2) leastRank = 6;
        else leastRank = 7-least;
      
        maxRank = leastRank - change;
        
        System.out.println(change);
        
        if(maxRank<1) maxRank =1;
        
        System.out.println(leastRank);
        
        answer[0] = maxRank;
        answer[1] = leastRank;
      
        
        return answer;
    }
}