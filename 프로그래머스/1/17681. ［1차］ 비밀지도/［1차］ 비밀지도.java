class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i<n; i++){
            int[] binary1 = makeBinaryArray(arr1[i], n);
            int[] binary2 = makeBinaryArray(arr2[i], n);
            
            StringBuilder sb = new StringBuilder();
            for(int j = n-1; j>=0;j--){
              if(binary1[j]==1||binary2[j]==1) sb.append("#");
              if(binary1[j]==0&&binary2[j]==0) sb.append(" ");
            }
            answer[i] = sb.toString(); 
        }
        return answer;
    }
    
    static int[] makeBinaryArray(int num, int n){
        int[] binary = new int[n];
        int idx = 0;
        while(num>=0){
            if(num%2==1){
                binary[idx] = 1;
            }
            else binary[idx] = 0;
            num/=2;
            if(num<=0) break;
            idx++;
        }
        return binary;
    }
}