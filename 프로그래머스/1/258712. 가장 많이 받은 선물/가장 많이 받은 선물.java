

class Solution {
    
    static int[][] matrix;
    static int[] givePresent;
    static int[] receivePresent;
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int len = friends.length;
        
        matrix = new int[len][len];
        
        givePresent = new int[len];
        receivePresent = new int[len];
        int[] nextPresent = new int[len];
        
        for(int i = 0; i<gifts.length;i++){
            String[] name = gifts[i].split(" ");
            String giver = name[0];
            String receiver = name[1];
            
            int gIdx = -1;
            int rIdx = -1;
            for(int j = 0; j<len;j++){
                if(friends[j].equals(giver)){
                    gIdx = j;
                    break;   
                }
            }
            for(int j = 0; j<len;j++){
                if(friends[j].equals(receiver)){
                    rIdx = j;
                    break;   
                }
            }
            matrix[gIdx][rIdx]++;
            givePresent[gIdx]++;
            receivePresent[rIdx]++;
        }
        
        // for(int r=0;r<len;r++){
        //     for(int c=0; c<len;c++){
        //         System.out.print(matrix[r][c]+" ");
        //     }
        //     System.out.println();
        // }
        
        for(int i = 0; i<len-1;i++){
            for(int j = i+1; j<len; j++){
                if((matrix[i][j]>0||matrix[j][i]>0)&&matrix[i][j]!=matrix[j][i]){
                    if(matrix[i][j]>matrix[j][i]) nextPresent[i]++;
                    else nextPresent[j]++;
                }
                else if((matrix[i][j]==0&&matrix[j][i]==0)||matrix[i][j]==matrix[j][i]){
                    if(getPresentScore(i)>getPresentScore(j)) nextPresent[i]++;
                    else if(getPresentScore(i)<getPresentScore(j)) nextPresent[j]++;
                }
            }
        }
        for(int i = 0; i<len;i++){
            answer = Math.max(nextPresent[i],answer);
        }
        return answer;
    }
    
    static int getPresentScore(int idx){
        return givePresent[idx]-receivePresent[idx];
    }
    
    // static boolean isRecord(int i, int j){
    //     return
    // }
    
}