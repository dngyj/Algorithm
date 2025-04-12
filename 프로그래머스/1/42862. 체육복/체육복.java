import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] clothes = new int[n+1];
        Arrays.fill(clothes, 1);
        
        for(int l : lost){
            clothes[l]--;
        }
        for(int r : reserve){
            clothes[r]++;
        }
        
        for(int i = 1; i<=n; i++){
            if(clothes[i]==0){
                if(i-1>0 && clothes[i-1]==2){
                    clothes[i-1]--;
                    clothes[i]++;
                    continue;
                }
                if(i+1<=n && clothes[i+1]==2){
                    clothes[i+1]--;
                    clothes[i]++;
                    continue;
                }
            }
        }
        
        for(int i = 1; i<=n; i++){
            if(clothes[i]!=0) answer++;
        }
        return answer;
    }
}