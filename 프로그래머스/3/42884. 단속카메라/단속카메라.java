import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int N = routes.length;
        
        Arrays.sort(routes, (a, b) -> a[1]-b[1]);
        
        int idx = 0;
        int count = 0;
        int cur_point = -30001;
        while(idx<N){
            if(routes[idx][0]>cur_point) {
                cur_point = routes[idx][1];
                count++;
            }
            idx++;
        }
        answer = count;
        return answer;
    }
}