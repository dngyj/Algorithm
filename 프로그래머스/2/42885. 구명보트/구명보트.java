import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int N = people.length;
        int left = 0;
        int right = N-1;

        while(left<right){
            if(people[left]+people[right]<=limit){
                left++;
            }
            right--;
        }
        
        answer = N-left;
        return answer;
    }
}