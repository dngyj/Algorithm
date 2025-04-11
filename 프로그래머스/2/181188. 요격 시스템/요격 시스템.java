import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        int N = targets.length;

        Arrays.sort(targets, (a,b) -> a[1]-b[1]);

        int idx = 0;
        int count = 0;
        int cur_point = -1; 
        
        while(idx<N){
            if(targets[idx][0]>=cur_point) {
                count++;
                cur_point = targets[idx][1];
            }
            idx++;
        }

        answer = count;
        return answer;
    }
}