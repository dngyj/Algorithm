import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int multi_sum = 0;
        for(int i = 0; i<A.length; i++){
            int multi = A[i]*B[B.length-1-i];
            multi_sum+=multi;
        }
        answer = multi_sum;
        
        return answer;
    }
}