import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        // int sum1 = Arrays.stream(queue1).sum();
        // int sum2 = Arrays.stream(queue2).sum();
        // int avg = (sum1+sum2)/2;
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long avg = 0;
        long sum1 = 0;
        
        for(int i=0;i<queue1.length;i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            avg+=queue1[i];
            avg+=queue2[i];
            sum1+=queue1[i];
        }
        avg/=2;
        boolean flag = false;
        
        while(sum1!=avg){
            
            int tmp = 0;
            if(sum1<avg){
                tmp = q2.poll();
                q1.add(tmp);
                sum1+=tmp;
            }
            else{
                tmp = q1.poll();
                q2.add(tmp);
                sum1-=tmp;
            }  
            answer++;
            if(answer>(queue1.length*4)) return -1;
        }
    
        return answer;
    }
 
}