import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int N = people.length;
        int left = 0;
        int right = N-1;
        int count = 0;
        boolean[] visited = new boolean[N];
        
        while(left<right){
            if(people[left]+people[right]<=limit){
                visited[left] = true;
                visited[right] = true;
                left++;
                right--;
                count++;
            }
            else{
                right--;
            }   
        }
        
        for(boolean v : visited){
            if(!v) count++;
        }
        answer = count;
        return answer;
    }
}