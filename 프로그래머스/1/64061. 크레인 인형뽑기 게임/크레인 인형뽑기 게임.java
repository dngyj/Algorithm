import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int move:moves){
            for(int r = 0;r<board[0].length;r++){
                if(board[r][move-1]!=0){
                    // System.out.print("r:"+r);
                    // System.out.println("v: "+board[r][move-1]);
                    if(!stack.isEmpty()&&stack.peek()==board[r][move-1]) {
                        stack.pop();
                        answer+=2;
                    }
                    else {
                        // System.out.println("v: "+board[r][move-1]);
                        stack.push(board[r][move-1]);
                    }
                    board[r][move-1] = 0;
                    break;
                }
            }

        }
        
        
        return answer;
    }
}