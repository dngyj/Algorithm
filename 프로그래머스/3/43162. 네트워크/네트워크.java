import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();
        for(int r = 0; r<n;r++){
            if(visited[r]) continue;
            visited[r] = true;
            answer++;
            for(int c = 0; c<n;c++){
                if(r==c) continue;
                if(computers[r][c]==0) continue;
                queue.add(c);
            }
            
            while(!queue.isEmpty()){
                int cur = queue.poll();
                visited[cur] = true;

                for(int c = 0; c<n;c++){
                    if(cur==c) continue;
                    if(computers[cur][c]==0) continue;
                    if(visited[c]) continue;
                    queue.add(c);
                    visited[c] = true;
                }
            }
            for(int k = 0; k<n;k++){
                System.out.print(visited[k]+" ");
            }
            System.out.println();
        }
        return answer;
    }
}