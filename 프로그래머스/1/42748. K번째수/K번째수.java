import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int r=0;r<commands.length;r++){
            int[] c = commands[r];
            int st = c[0]-1;
            int ed = c[1]-1;
            int num = c[2]-1;
            
            int len = ed-st+1;
            int[] arr = new int[len];
            
            for(int i = 0; i<len;i++){
                arr[i] = array[st+i];
            }
            Arrays.sort(arr);
            answer[r] = arr[num];
        }
        return answer;
    }
}