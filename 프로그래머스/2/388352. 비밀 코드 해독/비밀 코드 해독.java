class Solution {
    
    static int[] selected;
    static boolean[] visited;
    static int[][] q;
    static int[] ans;
    static int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        selected = new int[5];
        visited = new boolean[n+1];
        
        this.q = q;
        this.ans = ans;
        
        makeComb(n, 0, 1);
        
        return answer;
    }
    
    public void makeComb(int n, int idx, int start){
        if(idx == 5){
            if(checkValid(selected)) answer++;
        }
        else{
            for(int num = start; num <= n; num++){
                selected[idx] = num;
                makeComb(n, idx+1, num+1);
            }
        }
    }
    
    public boolean checkValid(int[] selected){
        for(int i = 0; i<q.length; i++){
            int hint = ans[i];
            int[] array = q[i];
            
            int count = 0;
            for(int k = 0; k<5; k++){
                for(int j = 0; j<5; j++){
                    if(selected[k]==array[j]) count++;
                }
            }
            if(count!=hint) return false;
        }
        return true;
    }
}