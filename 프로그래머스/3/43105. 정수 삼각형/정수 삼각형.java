class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        int[][] dp = new int[N][N];
        
        dp[0][0] = triangle[0][0];
        for(int r = 1; r<N;r++){
            dp[r][0] = triangle[r][0]+dp[r-1][0];
            for(int c = 1; c<triangle[r].length; c++){
              dp[r][c] = Math.max(dp[r-1][c-1]+triangle[r][c], dp[r-1][c]+triangle[r][c]);
            }
        }
        
        for(int c=0;c<N;c++){
            answer = Math.max(answer, dp[N-1][c]);
        }
        
        return answer;
    }
}